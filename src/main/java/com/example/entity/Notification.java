package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private long OrderId;
    private boolean isread;
    private String roomId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isRead() {
		return isread;
	}
	public void setisRead(boolean isread) {
		this.isread = isread;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long long1) {
		OrderId = long1;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + ", OrderId=" + OrderId + ", read=" + isread
				+ ", roomId=" + roomId + "]";
	}
	
}