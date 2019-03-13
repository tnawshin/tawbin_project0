// Arcade Shooter game
var canvas = document.getElementById('canvas');
// Get the canvas drawing context
var context = canvas.getContext('2d');

//call the makesquare function to draw the box
var shooter = makeSquare(50, canvas.height / 2 - 25, 50, 5);
var bullet = makeSquare(0, 0, 10, 10);
var up = false;
var down = false;
var space = false;
var shooting = false;
var enemies = [];
var enemyBaseSpeed = 2; 
var score = 0;
var timeBetweenEnemies = 5 * 1000;//default 5 secs
var timeoutId = null;

//x coordinate , y coordinate , length, speed 
function makeSquare(x, y, length, speed) {
  //make the square object for either shooter or bullet
  var square =  
  {
    x: x,
    y: y,
    l: length,
    s: speed,
    //draw function is defined to draw this box in the canvas
    draw: function () {
      context.fillRect(this.x, this.y, this.l, this.l);
    }
  };
  return square;
}

function makeEnemy() {
  var enemyX = canvas.width;
  //give the enemy boxes different size and different speed 
  var enemySize = Math.round((Math.random() * 15)) + 20;
  var enemyY = Math.round(Math.random() * (canvas.height - enemySize * 3)) + enemySize;
  var enemySpeed = Math.round(Math.random() * enemyBaseSpeed) + enemyBaseSpeed;
  //adding the square to the enemies' array 
  enemies.push(makeSquare(enemyX, enemyY, enemySize, enemySpeed));
}

// Check if number square1 is in the range square2 and square3 (exclusive)
function isWithin(coordinate1, coordinate2, coordinate3) {
  return (coordinate1 > coordinate2 && coordinate1 < coordinate3);
}

// Return true if two squares a and b are colliding, false otherwise
function isColliding(sq1, sq2) {
  var result = false;
  if (isWithin(sq1.x, sq2.x, sq2.x + sq2.l) || isWithin(sq1.x + sq1.l, sq2.x, sq2.x + sq2.l)) 
  {
    if (isWithin(sq1.y, sq2.y, sq2.y + sq2.l) || isWithin(sq1.y + sq1.l, sq2.y, sq2.y + sq2.l)) {
      result = true;
    }
  }
  return result;
}

// Show the game menu and instructions
function menu() 
{
  //Reset the canvas 
  reset();
  context.fillStyle = 'white';
  context.font = '36px Arial';
  context.textAlign = 'center';
  context.fillText('Shoot using space bar!', canvas.width / 2, canvas.height / 4);
  context.font = '24px Arial';
  context.fillText('Click to Start', canvas.width / 2, canvas.height / 2);
  context.font = '18px Arial';
  context.fillText('Up/Down to move, Space to shoot.', canvas.width / 2, (canvas.height / 4) * 3);
  // Start the game on a click
  canvas.addEventListener('click', startGame);
}

// Start the game
function startGame() {
  // Kick off the enemy spawn interval(5 secs). 
  timeoutId = setInterval(makeEnemy, timeBetweenEnemies);
  // Make the first enemy
  setTimeout(makeEnemy, 1000);
  // Kick off the draw loop
  // An array for enemies (in case there are more than one)
  enemies = [];

  // Track the user's score
  score = 0;

  // The delay between enemies (in milliseconds)
  timeBetweenEnemies = 5 * 1000;

  draw();
  // Stop listening for click events
  canvas.removeEventListener('click', startGame);
}

// Show the end game screen
function endGame() {
  // Stop the spawn interval
  clearInterval(timeoutId);
  // Show the final score
  reset();
  context.fillStyle = 'white';
  context.font = '24px Arial';
  context.textAlign = 'center';
  context.fillText('Game Over. Final Score: ' + score, canvas.width / 2, canvas.height / 2);
  context.font = '24px Arial';
  context.fillText('Click to Start', canvas.width / 2, (canvas.height / 4) * 3);
  canvas.addEventListener('click', startGame);
}

// Listen for keydown events
canvas.addEventListener('keydown', function (event) {
  //preventing the default key event
  event.preventDefault();
  if (event.keyCode === 38) { // UP
    up = true;
  }
  if (event.keyCode === 40) { // DOWN
    down = true;
  }
  if (event.keyCode === 32) { // SPACE
    shoot();
  }
});

// Shoot the bullet (if not already on screen)
function shoot() {
    shooting = true;
    bullet.x = shooter.x + shooter.l;
    bullet.y = shooter.y + shooter.l / 2;
  }

// Listen for keyup events
canvas.addEventListener('keyup', function (event) {
  event.preventDefault();
  if (event.keyCode === 38) { // UP 
    up = false;
  }
  if (event.keyCode === 40) { // DOWN
    down = false;
  }
});

// Clear the canvas
function reset() {
  context.fillStyle = 'black';
  context.fillRect(0, 0, 1000, 600);
}

// The main draw loop
function draw() 
{
  reset();
  var gameOver = false;
  
  // Move and draw the enemies
  enemies.forEach(function (enemy) {
    enemy.x = enemy.x-enemy.s; 
    if (enemy.x < 0) 
    {
      gameOver = true;
    }
    context.fillStyle = '#20EDB6';
    enemy.draw();
  });


  // Collide the shooter with enemies
  enemies.forEach(function (enemy)
   {
    if (isColliding(enemy, shooter)) {
      gameOver = true;
    }
  });
  // Move the shooter up and down
  if (down) 
  {
    shooter.y += shooter.s;  //incrementing the y coordinate with the speed factor
  }
  if (up) 
  {
    shooter.y -= shooter.s;   //decrementing the y coordinate with the speed factor
  }
  // check that it doesn't go out of bounds
  if (shooter.y < 0) 
  {
    shooter.y = 0;
  }

  if (shooter.y > canvas.height - shooter.l) 
  {
    shooter.y = canvas.height - shooter.l;
  }

// Draw the shooter
context.fillStyle = '#C70039';
shooter.draw();

  // Move and draw the bullet
  if (shooting) 
  {
    // Move the bullet
    bullet.x += bullet.s;
    // Collide the bullet with enemies
    enemies.forEach(function (enemy, index) {
      if (isColliding(bullet, enemy)) {
        enemies.splice(index, 1); //splice will remove
        score++;
        shooting = false;
      }
    });
    
    // Draw the bullet
    context.fillStyle = '#9820ED';
    bullet.draw();
  }

  // Draw the score
  context.fillStyle = 'white';
  context.font = '24px Arial';
  context.textAlign = 'left';
  context.fillText('Score: ' + score, 1, 25)
  // End or continue the game
  if (gameOver) 
  {
    endGame();
  } else 
  {
    window.requestAnimationFrame(draw);  //to animate another frame at the next repaint
  }
}

// Start the game
menu();
// keep the focus on a canvas element always, no matter where I click on the page
canvas.focus();