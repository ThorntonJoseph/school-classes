create table STUDENT(
	SSN int,
	First_Name VARCHAR(20),
	Last_Name VARCHAR(20) NOT NULL,
	Street VARCHAR(20)NOT NULL,
	City VARCHAR(20),
	zip int, 
	PRIMARY KEY(SSN)
);

create table CLASSROOM(
	RoomNo int,
	Building VARCHAR(20),
	Capacity int,
	PRIMARY KEY (RoomNo,Building)
);

create table COURSE (
	CourseNo VARCHAR(20), 
	Course_Name VARCHAR(30),
	Department VARCHAR(20),
	PRIMARY KEY(CourseNo)
);

create table SECTION (
	CourseNo VARCHAR(20),
	SectionNo int,
	PRIMARY KEY(CourseNo,SectionNo),
	FOREIGN KEY(CourseNo) REFERENCES COURSE(CourseNO)
);
	
create table ENROLLS(
	SSN int,
	SectionNO int,
	CourseNO VARCHAR(20),
	PRIMARY KEY(SSN,CourseNo,SectionNo),
	FOREIGN KEY(SSN) REFERENCES STUDENT(SSN)
);

create table EXAM(
	CourseNo VARCHAR(20),
	SectionNo int,
	ExamNo int,
	PRIMARY KEY(CourseNo,SectionNo,ExamNo)
);
	
create table TAKES(
	SSN int,
	CourseNo VARCHAR(20),
	SectionNo int,
	ExamNo int,
	Result VARCHAR(1),
        PRIMARY KEY(SSN,CourseNo,SectionNo,ExamNo),
	FOREIGN KEY(SSN) REFERENCES STUDENT(SSN)
);

create table CONDUCTED_IN(
	RoomNo int NOT NULL,
	Building VARCHAR(20) NOT NULL,
	CourseNo VARCHAR(20),
	SectionNo int,
	ExamNo int,
        PRIMARY KEY(RoomNo,CourseNo,SectionNo,ExamNo,Building)
	);
ALTER TABLE ENROLLS ADD CONSTRAINT fk_sec FOREIGN KEY(CourseNo,SectionNo) REFERENCES SECTION(CourseNo,SectionNo);
ALTER TABLE EXAM ADD CONSTRAINT fk2_sec FOREIGN KEY(CourseNo,SectionNo) REFERENCES SECTION(CourseNo,SectionNo);
ALTER TABLE CONDUCTED_IN ADD CONSTRAINT fk_room FOREIGN KEY(RoomNo,Building) REFERENCES CLASSROOM(RoomNo,Building);
ALTER TABLE TAKES ADD CONSTRAINT fk2_room FOREIGN KEY(CourseNo,SectionNo,ExamNo) REFERENCES EXAM(CourseNo,SectionNo,ExamNo);
ALTER TABLE CONDUCTED_IN ADD CONSTRAINT fk3_room FOREIGN KEY(CourseNo,SectionNo,ExamNo) REFERENCES EXAM(CourseNo,SectionNo,ExamNo);