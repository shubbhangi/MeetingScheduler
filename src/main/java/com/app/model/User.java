package com.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		@Column(name = "user_id")
		private int userId;
		
		@Column(name = "user_name")
		private String userName;
		
		@Column(name = "mobile_number")
		private String mobileNumber;
		
		@Column(name = "File_Create_Date")
		private LocalDateTime createDate;

		@OneToMany(cascade = javax.persistence.CascadeType.ALL)
		@JoinColumn(name ="user_id")
		private List<Meeting> meetingList;
		
		
		public User() {
			super();
		}

		public User(int userId, String userName, String mobileNumber, LocalDateTime createDate) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.mobileNumber = mobileNumber;
			this.createDate = createDate;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public LocalDateTime getCreateDate() {
			return createDate;
		}

		public void setCreateDate(LocalDateTime createDate) {
			this.createDate = createDate;
		}

		public List<Meeting> getMeetingList() {
			return meetingList;
		}

		public void setMeetingList(List<Meeting> meetingList) {
			this.meetingList = meetingList;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber
					+ ", createDate=" + createDate + ", meetingList=" + meetingList + "]";
		}

		
		
}
