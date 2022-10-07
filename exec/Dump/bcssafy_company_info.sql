-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 13.209.85.167    Database: bcssafy
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company_info`
--

DROP TABLE IF EXISTS `company_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_info` (
  `company_info_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `ceo` varchar(255) NOT NULL,
  `company_call` varchar(255) NOT NULL,
  `registration_file` varchar(255) NOT NULL,
  `registration_number` varchar(255) NOT NULL,
  `company_id` bigint DEFAULT NULL,
  PRIMARY KEY (`company_info_id`),
  UNIQUE KEY `UK_fr4mxwrpohm4rlvxt0a6pcwsl` (`company_id`),
  CONSTRAINT `FKr5m34qahvhcljmq07waqakeig` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=504 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_info`
--

LOCK TABLES `company_info` WRITE;
/*!40000 ALTER TABLE `company_info` DISABLE KEYS */;
INSERT INTO `company_info` VALUES (1,'부산광역시 남구','신승유','010-8759-5271','wow','wow',1),(2,'울산광역시 남구','하혁','010-3088-5513','wow','wow',2),(3,'전라북도 임실군','안영재','010-9251-7966','wow','wow',3),(4,'서울특별시 동대문구','안주은','010-5880-4820','wow','wow',4),(5,'충청남도 계룡시','배정원','010-3347-1436','wow','wow',5),(6,'제주특별자치도 제주시','하시윤','010-9247-6278','wow','wow',6),(7,'제주특별자치도 제주시','전유찬','010-3944-3002','wow','wow',7),(8,'인천광역시 동구','한민혁','010-9978-2134','wow','wow',8),(9,'울산광역시 남구','전하늘','010-4982-7469','wow','wow',9),(10,'전라북도 남원시','서재이','010-2833-5677','wow','wow',10),(11,'강원도 고성군','배민지','010-1927-2039','wow','wow',11),(12,'서울특별시 강북구','전준휘','010-9255-8825','wow','wow',12),(13,'강원도 동해시','유한빈','010-1424-3678','wow','wow',13),(14,'강원도 태백시','배소율','010-7417-1464','wow','wow',14),(15,'서울특별시 영등포구','조소미','010-3508-1666','wow','wow',15),(16,'대구광역시 남구','임유승','010-8117-2078','wow','wow',16),(17,'대구광역시 동구','홍소연','010-8200-2019','wow','wow',17),(18,'경기도 포천시','임찬혁','010-6832-4001','wow','wow',18),(19,'충청남도 청양군','전우석','010-2492-2627','wow','wow',19),(20,'대구광역시 달성군','김아영','010-4031-6047','wow','wow',20),(21,'서울특별시 광진구','권효린','010-9298-9724','wow','wow',21),(22,'대전광역시 동구','조건','010-5544-7624','wow','wow',22),(23,'전라북도 남원시','민성호','010-6399-3186','wow','wow',23),(24,'제주특별자치도 제주시','이리원','010-7067-1812','wow','wow',24),(25,'경상북도 청송군','하슬아','010-1643-3144','wow','wow',25),(26,'대구광역시 동구','임유성','010-6695-9574','wow','wow',26),(27,'인천광역시 동구','주윤후','010-4802-2817','wow','wow',27),(28,'대전광역시 서구','전유이','010-9838-4727','wow','wow',28),(29,'인천광역시 계양구','나동원','010-9178-3152','wow','wow',29),(30,'대전광역시 대덕구','차연주','010-3092-4795','wow','wow',30),(31,'경상북도 포항시','민민지','010-9547-6776','wow','wow',31),(32,'전라북도 전주시','전건영','010-8971-3376','wow','wow',32),(33,'제주특별자치도 제주시','고한결','010-1527-4908','wow','wow',33),(34,'울산광역시 동구','윤태율','010-6585-6700','wow','wow',34),(35,'부산광역시 금정구','노희원','010-9720-8587','wow','wow',35),(36,'전라북도 장수군','민승윤','010-3431-5880','wow','wow',36),(37,'강원도 양구군','차수지','010-2433-5937','wow','wow',37),(38,'경상북도 안동시','정세준','010-2071-2664','wow','wow',38),(39,'충청북도 진천군','민소원','010-9978-3694','wow','wow',39),(40,'충청남도 청양군','조성호','010-9382-2726','wow','wow',40),(41,'대전광역시 중구','조규원','010-8086-2967','wow','wow',41),(42,'대구광역시 서구','이요한','010-8038-6251','wow','wow',42),(43,'인천광역시 계양구','전우주','010-7175-1746','wow','wow',43),(44,'울산광역시 남구','장은준','010-2356-1384','wow','wow',44),(45,'경상남도 합천군','송서우','010-3625-8843','wow','wow',45),(46,'부산광역시 남구','나민기','010-8515-2011','wow','wow',46),(47,'인천광역시 웅진군','장재혁','010-5143-3676','wow','wow',47),(48,'충청북도 음성군','유현진','010-1561-9686','wow','wow',48),(49,'대전광역시 유성구','손재우','010-3122-4714','wow','wow',49),(50,'서울특별시 강남구','남예빈','010-5648-3584','wow','wow',50),(51,'전라북도 장수군','성나율','010-2243-1775','wow','wow',51),(52,'경기도 구리시','나윤서','010-9212-3355','wow','wow',52),(53,'경상북도 성주군','서용준','010-1257-6191','wow','wow',53),(54,'제주특별자치도 제주시','서우준','010-5016-4115','wow','wow',54),(55,'강원도 영월군','정도하','010-8275-5038','wow','wow',55),(56,'제주특별자치도 제주시','허아영','010-6193-9135','wow','wow',56),(57,'경기도 연천군','황혜진','010-5253-9421','wow','wow',57),(58,'울산광역시 울주군','임진영','010-8733-3505','wow','wow',58),(59,'충청북도 보은군','양원우','010-2623-8713','wow','wow',59),(60,'대구광역시 북구','허주영','010-8205-9880','wow','wow',60),(61,'광주광역시 광산구','안승찬','010-4269-6137','wow','wow',61),(62,'경상북도 영주시','조나윤','010-5165-6129','wow','wow',62),(63,'강원도 인제군','신도희','010-1028-2573','wow','wow',63),(64,'대구광역시 달성군','정예진','010-5813-7124','wow','wow',64),(65,'제주특별자치도 제주시','홍예슬','010-1223-1835','wow','wow',65),(66,'충청남도 예산군','임형준','010-8831-1280','wow','wow',66),(67,'대구광역시 달서구','김강준','010-6609-8452','wow','wow',67),(68,'강원도 양구군','박연우','010-4474-2421','wow','wow',68),(69,'강원도 원주시','양유하','010-9217-8035','wow','wow',69),(70,'인천광역시 중구','민지혁','010-3057-1029','wow','wow',70),(71,'서울특별시 관악구','송강우','010-7607-6829','wow','wow',71),(72,'전라북도 남원시','조정현','010-9304-7714','wow','wow',72),(73,'충청북도 단양군','양다인','010-9926-8724','wow','wow',73),(74,'부산광역시 수영구','신주호','010-1861-4037','wow','wow',74),(75,'대구광역시 남구','조유라','010-8362-5671','wow','wow',75),(76,'서울특별시 종로구','서수빈','010-7896-5450','wow','wow',76),(77,'제주특별자치도 제주시','남재연','010-3468-9129','wow','wow',77),(78,'전라북도 순창군','홍아인','010-9280-5161','wow','wow',78),(79,'울산광역시 동구','배정우','010-7107-7026','wow','wow',79),(80,'강원도 삼척시','주시완','010-7969-7440','wow','wow',80),(81,'충청북도 청주시','배영찬','010-3905-9398','wow','wow',81),(82,'경상남도 사천시','송아름','010-8456-4945','wow','wow',82),(83,'강원도 평창군','민준환','010-3181-7102','wow','wow',83),(84,'부산광역시 북구','곽재은','010-6921-5377','wow','wow',84),(85,'대전광역시 동구','나서윤','010-6035-6206','wow','wow',85),(86,'전라북도 남원시','주태웅','010-3417-3300','wow','wow',86),(87,'충청남도 부여군','임아윤','010-9557-5983','wow','wow',87),(88,'경상남도 합천군','유다윤','010-8410-4346','wow','wow',88),(89,'경상남도 거제시','노태리','010-4767-6559','wow','wow',89),(90,'광주광역시 서구','곽도준','010-4089-6437','wow','wow',90),(91,'경기도 양평군','민동준','010-5941-3185','wow','wow',91),(92,'대구광역시 달성군','하설','010-6890-4467','wow','wow',92),(93,'대전광역시 대덕구','전시윤','010-9919-7470','wow','wow',93),(94,'부산광역시 북구','신은성','010-1404-4482','wow','wow',94),(95,'충청북도 단양군','조범준','010-3982-4279','wow','wow',95),(96,'서울특별시 금천구','임준원','010-3866-3649','wow','wow',96),(97,'서울특별시 종로구','조세연','010-4107-2426','wow','wow',97),(98,'제주특별자치도 제주시','손도진','010-1285-3033','wow','wow',98),(99,'부산광역시 남구','황준후','010-6744-9552','wow','wow',99),(100,'부산광역시 사상구','주연준','010-8799-3579','wow','wow',100),(101,'강원도 동해시','박채린','010-7922-1217','wow','wow',101),(102,'경상남도 양산시','조유성','010-6701-5059','wow','wow',102),(103,'서울특별시 강남구','서서린','010-7008-4577','wow','wow',103),(104,'부산광역시 금정구','전민제','010-8885-3584','wow','wow',104),(105,'경기도 평택시','전도준','010-7217-7629','wow','wow',105),(106,'충청남도 천안시','박지온','010-4508-8501','wow','wow',106),(107,'경상북도 문경시','조이수','010-8908-7052','wow','wow',107),(108,'충청남도 당진시','주대현','010-2003-4974','wow','wow',108),(109,'경기도 구리시','정하민','010-1600-6044','wow','wow',109),(110,'서울특별시 구로구','조관우','010-2916-3604','wow','wow',110),(111,'서울특별시 서대문구','박기현','010-1654-5346','wow','wow',111),(112,'충청남도 서산시','송서윤','010-7086-2460','wow','wow',112),(113,'울산광역시 울주군','유경준','010-6551-3005','wow','wow',113),(114,'경상남도 거제시','유하민','010-4288-5345','wow','wow',114),(115,'서울특별시 강서구','양정연','010-4411-5742','wow','wow',115),(116,'경상남도 함안군','한나윤','010-6809-1307','wow','wow',116),(117,'광주광역시 서구','양수아','010-3205-2762','wow','wow',117),(118,'경기도 안성시','배해인','010-7271-7944','wow','wow',118),(119,'대구광역시 동구','황소영','010-7391-9805','wow','wow',119),(120,'강원도 춘천시','유지용','010-4398-3129','wow','wow',120),(121,'광주광역시 동구','임윤','010-4297-3596','wow','wow',121),(122,'제주특별자치도 제주시','최동혁','010-4315-3782','wow','wow',122),(123,'경상북도 김천시','정태이','010-8589-1059','wow','wow',123),(124,'대전광역시 중구','임동휘','010-4202-7069','wow','wow',124),(125,'경상남도 김해시','우정호','010-8598-6991','wow','wow',125),(126,'부산광역시 동래구','최태준','010-5099-1349','wow','wow',126),(127,'충청남도 아산시','이하음','010-4971-4323','wow','wow',127),(128,'대구광역시 중구','안민후','010-9455-6541','wow','wow',128),(129,'경상북도 영주시','백태호','010-3165-8581','wow','wow',129),(130,'울산광역시 동구','홍주희','010-3481-4623','wow','wow',130),(131,'경상남도 하동군','오준현','010-7986-9107','wow','wow',131),(132,'울산광역시 중구','백승재','010-6385-9557','wow','wow',132),(133,'경상북도 청도군','임현빈','010-8747-5663','wow','wow',133),(134,'충청남도 천안시','유라윤','010-1554-8605','wow','wow',134),(135,'전라북도 군산시','장지유','010-6226-2527','wow','wow',135),(136,'대구광역시 서구','손아라','010-6663-2463','wow','wow',136),(137,'경기도 과천시','심승유','010-5977-1321','wow','wow',137),(138,'서울특별시 광진구','우재용','010-7198-7725','wow','wow',138),(139,'강원도 양양군','성아름','010-8206-6298','wow','wow',139),(140,'경기도 양주시','유시윤','010-1978-6936','wow','wow',140),(141,'충청남도 청양군','차제인','010-3971-6097','wow','wow',141),(142,'제주특별자치도 제주시','권시윤','010-2161-6457','wow','wow',142),(143,'충청북도 단양군','우민호','010-8407-8353','wow','wow',143),(144,'대전광역시 유성구','남윤수','010-4974-4839','wow','wow',144),(145,'강원도 홍천군','정지은','010-1415-7541','wow','wow',145),(146,'전라북도 진안군','성지현','010-9839-3292','wow','wow',146),(147,'경기도 오산시','정환희','010-2141-2994','wow','wow',147),(148,'광주광역시 서구','주동주','010-5063-5341','wow','wow',148),(149,'서울특별시 영등포구','전대현','010-5023-7388','wow','wow',149),(150,'제주특별자치도 제주시','임지웅','010-7648-9027','wow','wow',150),(151,'전라북도 진안군','조승재','010-1016-2223','wow','wow',151),(152,'서울특별시 양천구','장주완','010-2669-6873','wow','wow',152),(153,'서울특별시 관악구','나현빈','010-2341-6202','wow','wow',153),(154,'제주특별자치도 제주시','남도연','010-8497-4962','wow','wow',154),(155,'전라북도 진안군','곽해준','010-1073-2197','wow','wow',155),(156,'전라북도 익산시','우태연','010-5339-6259','wow','wow',156),(157,'대구광역시 북구','박상훈','010-9118-6530','wow','wow',157),(158,'부산광역시 사하구','임시은','010-7417-4542','wow','wow',158),(159,'대구광역시 남구','신수빈','010-3534-2138','wow','wow',159),(160,'대전광역시 서구','주우재','010-6004-7559','wow','wow',160),(161,'인천광역시 강화군','하유은','010-3939-3489','wow','wow',161),(162,'부산광역시 중구','심서은','010-2489-5660','wow','wow',162),(163,'대전광역시 대덕구','임강우','010-1717-2970','wow','wow',163),(164,'제주특별자치도 제주시','남소민','010-3273-8787','wow','wow',164),(165,'제주특별자치도 제주시','성태준','010-6573-2255','wow','wow',165),(166,'경상북도 예천군','전정윤','010-3786-6255','wow','wow',166),(167,'경상남도 창녕군','신민아','010-2321-5450','wow','wow',167),(168,'경기도 화성시','김은별','010-7036-1580','wow','wow',168),(169,'충청북도 단양군','백여진','010-3224-6805','wow','wow',169),(170,'제주특별자치도 제주시','구온유','010-8337-5518','wow','wow',170),(171,'광주광역시 광산구','윤주현','010-9569-8688','wow','wow',171),(172,'대구광역시 중구','임하연','010-7081-7655','wow','wow',172),(173,'경상남도 함양군','한유정','010-6542-5746','wow','wow',173),(174,'부산광역시 강서구','윤관우','010-1183-7804','wow','wow',174),(175,'광주광역시 서구','구호영','010-9105-4366','wow','wow',175),(176,'광주광역시 동구','하승유','010-7753-7721','wow','wow',176),(177,'충청남도 부여군','민민채','010-8255-7665','wow','wow',177),(178,'경상남도 밀양시','허서빈','010-9813-5488','wow','wow',178),(179,'광주광역시 서구','조효은','010-4830-9189','wow','wow',179),(180,'경상북도 청송군','고찬희','010-2259-6261','wow','wow',180),(181,'경상남도 의령군','조채윤','010-6080-8449','wow','wow',181),(182,'제주특별자치도 제주시','권한준','010-8450-4939','wow','wow',182),(183,'경상남도 고성군','성윤진','010-2901-5242','wow','wow',183),(184,'인천광역시 웅진군','신지유','010-7870-9721','wow','wow',184),(185,'울산광역시 남구','하가을','010-1248-2724','wow','wow',185),(186,'광주광역시 동구','이재우','010-3627-8037','wow','wow',186),(187,'전라북도 진안군','정윤찬','010-8816-3895','wow','wow',187),(188,'대구광역시 동구','홍연재','010-1836-5729','wow','wow',188),(189,'충청북도 괴산군','안건','010-6319-4993','wow','wow',189),(190,'인천광역시 미추홀구','유병준','010-7907-4051','wow','wow',190),(191,'충청북도 보은군','윤효린','010-6727-6075','wow','wow',191),(192,'대전광역시 유성구','임현우','010-9351-4072','wow','wow',192),(193,'강원도 원주시','조지윤','010-9819-3806','wow','wow',193),(194,'강원도 삼척시','안재율','010-9921-2777','wow','wow',194),(195,'인천광역시 서구','신도희','010-2361-9534','wow','wow',195),(196,'대구광역시 북구','강율','010-6038-9960','wow','wow',196),(197,'광주광역시 남구','한다인','010-2923-6828','wow','wow',197),(198,'전라북도 장수군','곽선우','010-5521-9993','wow','wow',198),(199,'부산광역시 중구','장보미','010-7136-7760','wow','wow',199),(200,'부산광역시 금정구','문주연','010-5468-8962','wow','wow',200),(201,'대전광역시 중구','송은지','010-5393-9974','wow','wow',201),(202,'충청남도 계룡시','김재성','010-6717-7511','wow','wow',202),(203,'경상북도 구미시','구시윤','010-9176-7178','wow','wow',203),(204,'전라북도 익산시','최태경','010-8738-5222','wow','wow',204),(205,'경상남도 하동군','강승재','010-1408-2053','wow','wow',205),(206,'광주광역시 남구','권효린','010-2786-3914','wow','wow',206),(207,'서울특별시 노원구','양서진','010-6178-7265','wow','wow',207),(208,'대구광역시 달성군','남승찬','010-5092-5926','wow','wow',208),(209,'대구광역시 달서구','전도운','010-4221-4318','wow','wow',209),(210,'경상남도 창원시','조민제','010-6584-4119','wow','wow',210),(211,'강원도 평창군','주찬우','010-7993-7008','wow','wow',211),(212,'제주특별자치도 제주시','남예인','010-2916-3959','wow','wow',212),(213,'충청남도 보령시','구민결','010-6719-2704','wow','wow',213),(214,'광주광역시 남구','노은성','010-1198-8573','wow','wow',214),(215,'충청북도 충주시','심서정','010-4021-8836','wow','wow',215),(216,'인천광역시 연수구','조은우','010-2808-1564','wow','wow',216),(217,'인천광역시 강화군','서여원','010-9253-2546','wow','wow',217),(218,'대구광역시 중구','구효린','010-7841-7467','wow','wow',218),(219,'강원도 삼척시','고서호','010-4596-6760','wow','wow',219),(220,'충청남도 천안시','조현호','010-6166-6430','wow','wow',220),(221,'경상남도 밀양시','정민욱','010-8302-7224','wow','wow',221),(222,'인천광역시 연수구','유다윤','010-2523-8147','wow','wow',222),(223,'경상남도 사천시','홍사랑','010-3181-3453','wow','wow',223),(224,'인천광역시 웅진군','주시헌','010-7142-9642','wow','wow',224),(225,'제주특별자치도 제주시','오건후','010-3122-3440','wow','wow',225),(226,'울산광역시 동구','문서원','010-7224-3244','wow','wow',226),(227,'부산광역시 동래구','차승주','010-1563-4977','wow','wow',227),(228,'대구광역시 서구','안시형','010-2982-6780','wow','wow',228),(229,'경기도 가평군','성하성','010-7656-6482','wow','wow',229),(230,'부산광역시 동구','안근우','010-7473-2488','wow','wow',230),(231,'울산광역시 중구','양정은','010-3990-4482','wow','wow',231),(232,'전라북도 전주시','한시온','010-3299-7007','wow','wow',232),(233,'부산광역시 동구','유윤성','010-4933-5915','wow','wow',233),(234,'충청북도 음성군','허하엘','010-4573-1872','wow','wow',234),(235,'서울특별시 양천구','배보겸','010-1187-5169','wow','wow',235),(236,'부산광역시 해운대구','윤윤건','010-1101-9351','wow','wow',236),(237,'인천광역시 계양구','배은솔','010-4316-3832','wow','wow',237),(238,'경기도 김포시','노하진','010-8687-6734','wow','wow',238),(239,'경기도 고양시','윤지안','010-7108-7250','wow','wow',239),(240,'울산광역시 동구','신의준','010-7034-7348','wow','wow',240),(241,'전라북도 정읍시','전시온','010-9406-9211','wow','wow',241),(242,'대전광역시 유성구','허지우','010-8120-4688','wow','wow',242),(243,'제주특별자치도 제주시','허윤제','010-8032-5870','wow','wow',243),(244,'제주특별자치도 제주시','유수찬','010-7140-6796','wow','wow',244),(245,'울산광역시 남구','주서아','010-2992-8371','wow','wow',245),(246,'전라북도 군산시','신도연','010-4457-6696','wow','wow',246),(247,'경기도 부천시','홍슬아','010-2162-6288','wow','wow',247),(248,'인천광역시 웅진군','유지욱','010-2818-3424','wow','wow',248),(249,'광주광역시 서구','심예원','010-8413-2518','wow','wow',249),(250,'울산광역시 중구','조시윤','010-5053-4276','wow','wow',250),(251,'경상남도 거창군','박현','010-3071-1017','wow','wow',251),(252,'울산광역시 중구','문준원','010-9117-9307','wow','wow',252),(253,'경기도 광명시','서승호','010-5860-8391','wow','wow',253),(254,'광주광역시 북구','구영진','010-8851-2565','wow','wow',254),(255,'광주광역시 광산구','유시준','010-9493-3334','wow','wow',255),(256,'울산광역시 남구','심연주','010-2383-7494','wow','wow',256),(257,'강원도 속초시','구채희','010-6960-3161','wow','wow',257),(258,'강원도 양양군','문윤우','010-7942-3617','wow','wow',258),(259,'서울특별시 성동구','송미소','010-3074-6573','wow','wow',259),(260,'강원도 춘천시','한예담','010-2638-3839','wow','wow',260),(261,'전라북도 완주군','김한별','010-3497-8686','wow','wow',261),(262,'경기도 광주시','홍한율','010-1129-2295','wow','wow',262),(263,'서울특별시 성동구','민세린','010-7641-7177','wow','wow',263),(264,'울산광역시 울주군','곽세영','010-4502-6797','wow','wow',264),(265,'울산광역시 중구','송태이','010-8340-6994','wow','wow',265),(266,'경상남도 진주시','손온유','010-1372-3804','wow','wow',266),(267,'제주특별자치도 제주시','하해성','010-2631-4944','wow','wow',267),(268,'경상남도 통영시','신윤서','010-5121-9140','wow','wow',268),(269,'전라북도 정읍시','신원우','010-6551-8453','wow','wow',269),(270,'경상남도 함양군','곽호영','010-8889-4984','wow','wow',270),(271,'대구광역시 달서구','차승혁','010-4768-7561','wow','wow',271),(272,'울산광역시 중구','유연수','010-9666-6558','wow','wow',272),(273,'강원도 원주시','한준원','010-4511-8603','wow','wow',273),(274,'대구광역시 달성군','백재이','010-9765-3135','wow','wow',274),(275,'대전광역시 동구','백지현','010-3635-3995','wow','wow',275),(276,'충청남도 부여군','노혜윤','010-7295-2852','wow','wow',276),(277,'강원도 고성군','안연아','010-6287-7619','wow','wow',277),(278,'충청북도 단양군','김도은','010-7588-1660','wow','wow',278),(279,'광주광역시 동구','장승혁','010-5546-6887','wow','wow',279),(280,'경상북도 영천시','전주원','010-4774-5781','wow','wow',280),(281,'서울특별시 중랑구','조은혜','010-5461-6394','wow','wow',281),(282,'서울특별시 용산구','우연우','010-3862-4200','wow','wow',282),(283,'광주광역시 서구','손태오','010-1957-1041','wow','wow',283),(284,'충청북도 옥천군','조찬민','010-4379-5685','wow','wow',284),(285,'대전광역시 대덕구','성도경','010-4485-9135','wow','wow',285),(286,'경상북도 울진군','조은율','010-2042-7373','wow','wow',286),(287,'대구광역시 서구','정동건','010-8825-2335','wow','wow',287),(288,'경상북도 문경시','주다원','010-4819-1746','wow','wow',288),(289,'울산광역시 울주군','홍도경','010-6437-4897','wow','wow',289),(290,'대전광역시 유성구','양재훈','010-6389-3565','wow','wow',290),(291,'충청남도 계룡시','홍민','010-5691-4924','wow','wow',291),(292,'부산광역시 기장군','안현서','010-4866-4085','wow','wow',292),(293,'제주특별자치도 제주시','구은수','010-6386-1886','wow','wow',293),(294,'제주특별자치도 제주시','고규리','010-9381-9869','wow','wow',294),(295,'경기도 안성시','김소미','010-2883-7206','wow','wow',295),(296,'부산광역시 사하구','심재은','010-1330-7109','wow','wow',296),(297,'제주특별자치도 제주시','정유경','010-3609-3707','wow','wow',297),(298,'경상남도 거제시','신하린','010-3827-1989','wow','wow',298),(299,'광주광역시 동구','윤준','010-7685-3160','wow','wow',299),(300,'울산광역시 울주군','조라윤','010-6583-5972','wow','wow',300),(301,'전라북도 무주군','배성진','010-2898-4173','wow','wow',301),(302,'대구광역시 동구','박준수','010-9925-9546','wow','wow',302),(303,'경상북도 군위군','한민승','010-3866-3922','wow','wow',303),(304,'제주특별자치도 제주시','최소원','010-5117-7525','wow','wow',304),(305,'울산광역시 중구','조민아','010-8309-9273','wow','wow',305),(306,'경상남도 통영시','남승연','010-6369-5369','wow','wow',306),(307,'대전광역시 중구','강윤재','010-1464-8716','wow','wow',307),(308,'전라북도 무주군','우민정','010-6941-7192','wow','wow',308),(309,'강원도 철원군','신이수','010-6247-2766','wow','wow',309),(310,'경상북도 청도군','나하온','010-8793-9995','wow','wow',310),(311,'경기도 광주시','안가인','010-6643-9567','wow','wow',311),(312,'충청남도 서산시','이희원','010-3351-2361','wow','wow',312),(313,'강원도 삼척시','한지성','010-2581-9701','wow','wow',313),(314,'제주특별자치도 제주시','양다솜','010-9729-9747','wow','wow',314),(315,'울산광역시 남구','신유진','010-9112-8126','wow','wow',315),(316,'대전광역시 대덕구','고가람','010-5290-2750','wow','wow',316),(317,'광주광역시 광산구','곽경준','010-1712-9670','wow','wow',317),(318,'경기도 수원시','심아인','010-2668-5222','wow','wow',318),(319,'인천광역시 중구','신지원','010-8630-6478','wow','wow',319),(320,'충청북도 괴산군','하상윤','010-4329-2238','wow','wow',320),(321,'경상북도 청송군','노민결','010-4856-1425','wow','wow',321),(322,'강원도 춘천시','황효린','010-5719-1971','wow','wow',322),(323,'경기도 김포시','김혜성','010-5773-1218','wow','wow',323),(324,'제주특별자치도 제주시','우서은','010-8520-8179','wow','wow',324),(325,'울산광역시 동구','전성훈','010-4077-4535','wow','wow',325),(326,'전라북도 무주군','백도희','010-8153-3256','wow','wow',326),(327,'경상북도 울릉군','권성우','010-1106-5246','wow','wow',327),(328,'서울특별시 강서구','안동혁','010-7615-7568','wow','wow',328),(329,'제주특별자치도 제주시','구유림','010-5459-5386','wow','wow',329),(330,'경기도 구리시','송가빈','010-3299-1390','wow','wow',330),(331,'제주특별자치도 제주시','조나린','010-4375-3900','wow','wow',331),(332,'인천광역시 웅진군','고세영','010-7150-2580','wow','wow',332),(333,'대전광역시 대덕구','정나율','010-4652-6112','wow','wow',333),(334,'전라북도 임실군','문지안','010-7495-4980','wow','wow',334),(335,'충청북도 단양군','이승혁','010-3534-9728','wow','wow',335),(336,'서울특별시 강서구','정하엘','010-4834-7533','wow','wow',336),(337,'경기도 안산시','배유하','010-9911-4257','wow','wow',337),(338,'경상북도 김천시','오은성','010-2056-4549','wow','wow',338),(339,'울산광역시 북구','조영민','010-1995-1519','wow','wow',339),(340,'충청남도 예산군','백도은','010-7432-5349','wow','wow',340),(341,'서울특별시 강서구','임연재','010-5438-2722','wow','wow',341),(342,'인천광역시 연수구','우재은','010-5258-3503','wow','wow',342),(343,'제주특별자치도 제주시','전지영','010-8823-5617','wow','wow',343),(344,'대전광역시 중구','송윤진','010-2499-8187','wow','wow',344),(345,'제주특별자치도 제주시','신서윤','010-7888-2199','wow','wow',345),(346,'전라북도 군산시','최예은','010-7949-1953','wow','wow',346),(347,'충청남도 천안시','정한빈','010-2428-3990','wow','wow',347),(348,'울산광역시 남구','남수영','010-4659-7377','wow','wow',348),(349,'제주특별자치도 제주시','차지혁','010-9040-4731','wow','wow',349),(350,'서울특별시 양천구','성연주','010-1041-1617','wow','wow',350),(351,'경상남도 합천군','전재이','010-9360-5770','wow','wow',351),(352,'부산광역시 기장군','황재범','010-4495-2091','wow','wow',352),(353,'경기도 파주시','유호진','010-7665-3443','wow','wow',353),(354,'경상남도 합천군','황시원','010-9483-1480','wow','wow',354),(355,'광주광역시 광산구','곽은준','010-8245-2485','wow','wow',355),(356,'대전광역시 동구','유인우','010-8658-4363','wow','wow',356),(357,'울산광역시 울주군','심정민','010-8715-6195','wow','wow',357),(358,'서울특별시 강북구','한윤호','010-5559-3533','wow','wow',358),(359,'광주광역시 서구','문서영','010-4740-8541','wow','wow',359),(360,'제주특별자치도 제주시','전다희','010-9788-4384','wow','wow',360),(361,'충청북도 보은군','곽이찬','010-7404-5129','wow','wow',361),(362,'인천광역시 부평구','이환희','010-2559-6939','wow','wow',362),(363,'경기도 이천시','임예린','010-5609-8924','wow','wow',363),(364,'대전광역시 중구','유도하','010-1052-9283','wow','wow',364),(365,'인천광역시 동구','윤채연','010-4812-6467','wow','wow',365),(366,'대구광역시 중구','노재영','010-8465-3416','wow','wow',366),(367,'광주광역시 동구','우승우','010-4192-6093','wow','wow',367),(368,'대전광역시 중구','양하늘','010-9282-4030','wow','wow',368),(369,'울산광역시 북구','최민호','010-7484-7332','wow','wow',369),(370,'충청북도 단양군','차성재','010-8744-1197','wow','wow',370),(371,'충청북도 단양군','하민건','010-9209-5470','wow','wow',371),(372,'대전광역시 대덕구','문태영','010-9832-5743','wow','wow',372),(373,'대전광역시 대덕구','백수진','010-5000-4616','wow','wow',373),(374,'전라북도 완주군','구연수','010-5602-4923','wow','wow',374),(375,'서울특별시 금천구','조선우','010-7027-2279','wow','wow',375),(376,'전라북도 익산시','송경민','010-4474-5244','wow','wow',376),(377,'인천광역시 계양구','장기범','010-1292-7294','wow','wow',377),(378,'전라북도 임실군','배아라','010-4643-9351','wow','wow',378),(379,'서울특별시 관악구','주온유','010-8396-6821','wow','wow',379),(380,'울산광역시 북구','전다율','010-7267-4968','wow','wow',380),(381,'충청남도 당진시','홍희원','010-2779-9196','wow','wow',381),(382,'충청북도 영동군','권루아','010-1775-3057','wow','wow',382),(383,'대전광역시 유성구','한다율','010-1988-5056','wow','wow',383),(384,'전라북도 고창군','남성재','010-8344-6058','wow','wow',384),(385,'제주특별자치도 제주시','하민호','010-4671-3513','wow','wow',385),(386,'제주특별자치도 제주시','배강현','010-7993-8627','wow','wow',386),(387,'강원도 양구군','한재용','010-7863-4441','wow','wow',387),(388,'부산광역시 사하구','양해나','010-5249-3861','wow','wow',388),(389,'충청남도 논산시','전영민','010-9171-7070','wow','wow',389),(390,'충청남도 공주시','임서빈','010-8989-6692','wow','wow',390),(391,'울산광역시 중구','권서원','010-8752-2182','wow','wow',391),(392,'경기도 김포시','성서후','010-6898-3755','wow','wow',392),(393,'부산광역시 남구','이도현','010-4824-6011','wow','wow',393),(394,'서울특별시 양천구','정시헌','010-9080-7697','wow','wow',394),(395,'충청남도 공주시','유형우','010-5879-8518','wow','wow',395),(396,'부산광역시 사하구','심은수','010-1768-5104','wow','wow',396),(397,'서울특별시 송파구','임지윤','010-5460-1030','wow','wow',397),(398,'경상북도 울릉군','서태웅','010-4592-6193','wow','wow',398),(399,'경상북도 군위군','남재은','010-3654-1500','wow','wow',399),(400,'경상북도 구미시','최승혁','010-4216-5876','wow','wow',400),(401,'충청북도 옥천군','신주영','010-6978-9177','wow','wow',401),(402,'울산광역시 울주군','유혜진','010-6035-6235','wow','wow',402),(403,'충청북도 제천시','백태인','010-5380-6914','wow','wow',403),(404,'제주특별자치도 제주시','차재빈','010-2184-1393','wow','wow',404),(405,'충청남도 서산시','신윤서','010-6537-3193','wow','wow',405),(406,'부산광역시 서구','조세희','010-4272-2558','wow','wow',406),(407,'울산광역시 북구','강고은','010-8325-9831','wow','wow',407),(408,'강원도 양양군','오준후','010-2713-2845','wow','wow',408),(409,'인천광역시 강화군','송대현','010-5026-5260','wow','wow',409),(410,'제주특별자치도 제주시','임한울','010-4389-9095','wow','wow',410),(411,'광주광역시 광산구','김유빈','010-4378-2877','wow','wow',411),(412,'강원도 철원군','신시현','010-2982-6413','wow','wow',412),(413,'대전광역시 유성구','신윤주','010-6004-8708','wow','wow',413),(414,'제주특별자치도 제주시','고민','010-6237-2594','wow','wow',414),(415,'충청북도 충주시','주가온','010-5240-4939','wow','wow',415),(416,'강원도 홍천군','우상준','010-6127-5761','wow','wow',416),(417,'인천광역시 동구','하소희','010-3442-3145','wow','wow',417),(418,'광주광역시 동구','이규빈','010-7416-8828','wow','wow',418),(419,'충청북도 제천시','민채영','010-4743-2674','wow','wow',419),(420,'대전광역시 대덕구','송수호','010-9817-9790','wow','wow',420),(421,'강원도 화천군','장지아','010-7359-1038','wow','wow',421),(422,'광주광역시 서구','배태인','010-4018-4322','wow','wow',422),(423,'제주특별자치도 제주시','배준성','010-6412-1484','wow','wow',423),(424,'대전광역시 대덕구','한지우','010-1287-7499','wow','wow',424),(425,'충청남도 공주시','민동우','010-3199-8482','wow','wow',425),(426,'제주특별자치도 제주시','이지수','010-3234-9079','wow','wow',426),(427,'대전광역시 대덕구','구우준','010-4345-6961','wow','wow',427),(428,'부산광역시 영도구','곽한율','010-4236-7334','wow','wow',428),(429,'인천광역시 남동구','성은유','010-2930-4287','wow','wow',429),(430,'강원도 양양군','조연재','010-7470-5916','wow','wow',430),(431,'대전광역시 서구','한태민','010-2124-6438','wow','wow',431),(432,'강원도 철원군','전현지','010-6524-5627','wow','wow',432),(433,'부산광역시 사상구','양민찬','010-2531-6255','wow','wow',433),(434,'울산광역시 중구','정은설','010-6119-9372','wow','wow',434),(435,'경상북도 봉화군','고효원','010-2064-3654','wow','wow',435),(436,'제주특별자치도 제주시','정서하','010-5871-3670','wow','wow',436),(437,'대구광역시 수성구','고재호','010-7923-4594','wow','wow',437),(438,'강원도 강릉시','배은서','010-3180-6061','wow','wow',438),(439,'충청북도 진천군','문시형','010-5747-5514','wow','wow',439),(440,'충청남도 아산시','구도경','010-7212-5777','wow','wow',440),(441,'대구광역시 북구','배연희','010-2610-9562','wow','wow',441),(442,'전라북도 고창군','성이찬','010-9994-3618','wow','wow',442),(443,'경기도 구리시','우시은','010-3228-5663','wow','wow',443),(444,'인천광역시 강화군','노주영','010-5112-9069','wow','wow',444),(445,'서울특별시 구로구','조윤진','010-7328-3443','wow','wow',445),(446,'경상남도 창녕군','정태오','010-8405-8492','wow','wow',446),(447,'경상북도 영덕군','임세훈','010-2678-2320','wow','wow',447),(448,'경기도 파주시','김환','010-2451-5625','wow','wow',448),(449,'제주특별자치도 제주시','김은설','010-1823-8162','wow','wow',449),(450,'대구광역시 달성군','박성찬','010-9607-5765','wow','wow',450),(451,'광주광역시 서구','장찬민','010-6119-2636','wow','wow',451),(452,'대구광역시 남구','안이현','010-3234-5094','wow','wow',452),(453,'광주광역시 동구','유지석','010-5468-7646','wow','wow',453),(454,'충청남도 아산시','한아인','010-5389-4037','wow','wow',454),(455,'제주특별자치도 제주시','차우찬','010-3779-3149','wow','wow',455),(456,'충청북도 제천시','김세은','010-7114-5175','wow','wow',456),(457,'경상남도 양산시','황찬민','010-4045-9961','wow','wow',457),(458,'광주광역시 북구','전나율','010-1114-9235','wow','wow',458),(459,'광주광역시 북구','김효원','010-7198-4663','wow','wow',459),(460,'전라북도 익산시','민하율','010-7579-5506','wow','wow',460),(461,'서울특별시 구로구','유민결','010-8330-8692','wow','wow',461),(462,'울산광역시 울주군','배예원','010-3716-1292','wow','wow',462),(463,'전라북도 진안군','최영찬','010-6904-3895','wow','wow',463),(464,'광주광역시 광산구','권세연','010-4068-3866','wow','wow',464),(465,'충청남도 홍성군','곽은우','010-5517-2249','wow','wow',465),(466,'대구광역시 동구','송예성','010-4043-5577','wow','wow',466),(467,'서울특별시 종로구','남윤슬','010-9574-7929','wow','wow',467),(468,'울산광역시 남구','배지현','010-3244-5789','wow','wow',468),(469,'대구광역시 달성군','구상민','010-6847-1210','wow','wow',469),(470,'광주광역시 북구','성상훈','010-6761-8388','wow','wow',470),(471,'경상남도 진주시','문시연','010-1560-4307','wow','wow',471),(472,'전라북도 전주시','나시준','010-8652-5096','wow','wow',472),(473,'대구광역시 수성구','신지윤','010-1739-1898','wow','wow',473),(474,'부산광역시 수영구','전리안','010-8399-8770','wow','wow',474),(475,'제주특별자치도 제주시','차진혁','010-8798-8580','wow','wow',475),(476,'서울특별시 영등포구','서경훈','010-1334-4681','wow','wow',476),(477,'인천광역시 미추홀구','백상우','010-8455-9416','wow','wow',477),(478,'충청남도 계룡시','신민건','010-6456-4176','wow','wow',478),(479,'부산광역시 영도구','임지혜','010-1845-3495','wow','wow',479),(480,'인천광역시 남동구','신주원','010-3998-2930','wow','wow',480),(481,'강원도 고성군','임현서','010-7978-8393','wow','wow',481),(482,'제주특별자치도 제주시','정동현','010-4479-6999','wow','wow',482),(483,'인천광역시 부평구','민민찬','010-5204-8833','wow','wow',483),(484,'충청북도 보은군','손시훈','010-2539-4153','wow','wow',484),(485,'대구광역시 동구','임준서','010-6205-6454','wow','wow',485),(486,'제주특별자치도 제주시','전재성','010-3465-4135','wow','wow',486),(487,'경상남도 밀양시','전호영','010-6671-8430','wow','wow',487),(488,'전라북도 완주군','서해성','010-7972-2191','wow','wow',488),(489,'경상북도 문경시','한은수','010-2807-4327','wow','wow',489),(490,'전라북도 전주시','손현빈','010-7615-6021','wow','wow',490),(491,'울산광역시 북구','노준민','010-4493-8882','wow','wow',491),(492,'서울특별시 노원구','황선재','010-6539-2443','wow','wow',492);
/*!40000 ALTER TABLE `company_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-07 11:39:14
