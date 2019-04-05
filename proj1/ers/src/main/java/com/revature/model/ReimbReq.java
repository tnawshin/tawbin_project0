package com.revature.model;

public class ReimbReq {
	
	private int ReqID;
	private double Amount;
	private String SubDate;
	private String ResolveDate;
	private String Description;
	private String Reciept;
	private String Author;
    private String Resolver;
	private String Status;
	private String Type;
	
	private int AuthorID;
    private int ResolverID;
	private int StatusID;
	private int TypeID;
	
	
	public ReimbReq() {}
	public ReimbReq(double amount, String description, int typeID) {
		super();
		Amount = amount;
		Description = description;
		TypeID = typeID;
	}

	
	public ReimbReq(int reqID, double amount, String subDate, String resolveDate, String description, String reciept,
			String author, String resolver, String status, String type,int authorID,int resolverID,int statusID,int typeID) {
		super();
		ReqID = reqID;
		Amount = amount;
		SubDate = subDate;
		ResolveDate = resolveDate;
		Description = description;
		Reciept = reciept;
		Author = author;
		Resolver = resolver;
		Status = status;
		Type = type;
		AuthorID = authorID;
		ResolverID = resolverID;
		StatusID = statusID;
		TypeID = typeID;
	}
	public int getReqID() {
		return ReqID;
	}
	public void setReqID(int reqID) {
		ReqID = reqID;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getSubDate() {
		return SubDate;
	}
	public void setSubDate(String subDate) {
		SubDate = subDate;
	}
	public String getResolveDate() {
		return ResolveDate;
	}
	public void setResolveDate(String resolveDate) {
		ResolveDate = resolveDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getReciept() {
		return Reciept;
	}
	public void setReciept(String reciept) {
		Reciept = reciept;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getResolver() {
		return Resolver;
	}
	public void setResolver(String resolver) {
		Resolver = resolver;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public int getResolverID() {
		return ResolverID;
	}
	public void setResolverID(int resolverID) {
		ResolverID = resolverID;
	}
	public int getStatusID() {
		return StatusID;
	}
	public void setStatusID(int statusID) {
		StatusID = statusID;
	}
	public int getTypeID() {
		return TypeID;
	}
	public void setTypeID(int typeID) {
		TypeID = typeID;
	}
	
	
	
    
    
}
