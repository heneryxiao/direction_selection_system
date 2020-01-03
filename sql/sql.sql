/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.62 : Database - direction_selection_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`direction_selection_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `direction_selection_system`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `branchId` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `selected` int(3) NOT NULL DEFAULT '0',
  `limited` int(3) NOT NULL,
  PRIMARY KEY (`branchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

insert  into `branch`(`branchId`,`name`,`selected`,`limited`) values ('B1001','移动开发',0,40),('B1002','软件测试',0,40),('B1003','游戏开发',40,40),('B1004','大数据',2,40);

/*Table structure for table `c3p0testtable` */

DROP TABLE IF EXISTS `c3p0testtable`;

CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `c3p0testtable` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseId` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `branchId` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `FK_course-branch` (`branchId`),
  CONSTRAINT `FK_course-branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseId`,`name`,`branchId`) values ('C2001','ios入门','B1001'),('C2002','接口测试','B1002'),('C2003','小程序游戏','B1003'),('C2004','python基础','B1004'),('C2005','android开发','B1001'),('C2006','linux基础','B1002'),('C2007','3D游戏开发','B1003'),('C2008','爬虫实战','B1004');

/*Table structure for table `course_leader` */

DROP TABLE IF EXISTS `course_leader`;

CREATE TABLE `course_leader` (
  `cId` varchar(11) NOT NULL,
  `name` varchar(8) NOT NULL,
  `gender` varchar(2) NOT NULL DEFAULT '男',
  `tId` varchar(11) DEFAULT NULL,
  `courseId` varchar(5) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `introduce` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cId`),
  KEY `FK_course_leader-teacher` (`tId`),
  KEY `FK_course_leader-course` (`courseId`),
  CONSTRAINT `FK_course_leader-course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_course_leader-teacher` FOREIGN KEY (`tId`) REFERENCES `teacher` (`tId`),
  CONSTRAINT `FK_course_leader-user` FOREIGN KEY (`cId`) REFERENCES `user` (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_leader` */

insert  into `course_leader`(`cId`,`name`,`gender`,`tId`,`courseId`,`email`,`introduce`) values ('C30001','王一','男','T40001','C2001',NULL,'这是一个课程简介！！！'),('C30002','王二','男','T40002','C2002',NULL,'这是一个课程简介！！！'),('C30003','王三','男','T40003','C2003',NULL,'这是一个课程简介！！！'),('C30004','王四','男','T40004','C2004',NULL,'这是一个课程简介！！！'),('C30005','王五','男','T40005','C2005',NULL,'这是一个课程简介！！！'),('C30006','王六','男','T40006','C2006',NULL,'这是一个课程简介！！！'),('C30007','王七','男','T40007','C2007',NULL,'这是一个课程简介！！！'),('C30008','王八','男','T40008','C2008',NULL,'这是一个课程简介！！！');

/*Table structure for table `leader` */

DROP TABLE IF EXISTS `leader`;

CREATE TABLE `leader` (
  `lId` varchar(11) NOT NULL,
  `name` varchar(8) NOT NULL,
  `gender` varchar(2) NOT NULL DEFAULT '男',
  `profession` varchar(20) DEFAULT NULL,
  `branchId` varchar(5) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`lId`),
  KEY `FK_leader-branch` (`branchId`),
  CONSTRAINT `FK_leader-branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`),
  CONSTRAINT `FK_leader-user` FOREIGN KEY (`lId`) REFERENCES `user` (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leader` */

insert  into `leader`(`lId`,`name`,`gender`,`profession`,`branchId`,`email`) values ('B20001','李一','男','软件工程','B1001',NULL),('P10001','张一','男','软件工程','B1001',NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sId` varchar(11) NOT NULL,
  `name` varchar(8) NOT NULL,
  `gender` varchar(2) NOT NULL DEFAULT '男',
  `profession` varchar(20) NOT NULL,
  `branchId` varchar(5) DEFAULT 'null',
  `clazz` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sId`),
  KEY `FK_student-branch` (`branchId`),
  CONSTRAINT `FK_student-branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`),
  CONSTRAINT `FK_student-user` FOREIGN KEY (`sId`) REFERENCES `user` (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sId`,`name`,`gender`,`profession`,`branchId`,`clazz`,`email`) values ('16210120608','肖智海','男','软件工程','B1004','6班',''),('16210120630','姚洪斌','男','软件工程','B1004','6班','');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tId` varchar(11) NOT NULL,
  `name` varchar(8) NOT NULL,
  `gender` varchar(2) NOT NULL DEFAULT '男',
  `introduce` varchar(200) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tId`),
  CONSTRAINT `FK_teacher-user` FOREIGN KEY (`tId`) REFERENCES `user` (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tId`,`name`,`gender`,`introduce`,`email`) values ('T40001','赵一','男','这是一个老师简介！！！',''),('T40002','赵二','男','这是一个老师简介！！！',''),('T40003','赵三','男','这是一个老师简介！！！',''),('T40004','赵四','男','这是一个老师简介！！！',''),('T40005','赵五','男','这是一个老师简介！！！',NULL),('T40006','赵六','男','这是一个老师简介！！！',NULL),('T40007','赵七','男','这是一个老师简介！！！',NULL),('T40008','赵八','男','这是一个老师简介！！！',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` varchar(11) NOT NULL,
  `password` varchar(18) NOT NULL,
  `type` int(1) NOT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uId`,`password`,`type`) values ('1','1',4),('16210120608','123',6),('16210120630','123',6),('admin','admin',1),('B20001','123',3),('C30001','123',4),('C30002','123',4),('C30003','123',4),('C30004','123',4),('C30005','123',4),('C30006','123',4),('C30007','123',4),('C30008','123',4),('P10001','123',2),('T40001','123',5),('T40002','123',5),('T40003','123',5),('T40004','123',5),('T40005','123',5),('T40006','123',5),('T40007','123',5),('T40008','123',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
