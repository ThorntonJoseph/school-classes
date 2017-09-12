SELECT First_Name,Last_Name,s.SSN
FROM COURSE AS C,STUDENT as s,ENROLLS as e
WHERE	s.ssn=e.ssn and C.Course_Name='Computer Architecture' and C.CourseNo=e.CourseNo

SELECT SSN,First_Name,Last_Name,CourseNo,SectionNo
FROM COURSE as c, STUDENT as s, ENROLLS as e
WHERE s.ssn=e.ssn and c.Course_Name='VLSI'and e.CourseNo=c.CourseNo

SELECT Course_Name,CourseNo
FROM COURSE as c
WHERE (SELECT COUNT(*) FROM TAKES as t WHERE t.CourseNo=c.CourseNo)>2

SELECT SSN,First_name,Last_Name
FROM STUDENT AS s
WHERE (SELECT COUNT(*) FROM TAKES as t WHERE t.Result='A' and s.ssn=t.ssn)>1

SELECT ExamNo,CourseNo,SectionNo,c.Building,Capacity,c.RoomNo
FROM CONDUCTED_IN as c,CLASSROOM as b
WHERE c.Building='Riverside Hall' and c.Building=b.Building

SELECT s.SSN,s.First_Name,s.Last_Name
FROM ENROLLS as e, STUDENT as s
WHERE e.ssn=s.ssn and e.CourseNo='C11'

SELECT Course_Name,COUNT(*)
FROM  COURSE as c,SECTION as s
where c.CourseNo=s.CourseNo
GROUP BY c.CourseNo
HAVING COUNT(s.CourseNo)>2

DROP TABLE TAKES,ENROLLS,CONDUCTED_IN,EXAM,SECTION,COURSE,STUDENT,CLASSROOM;