
INSERT INTO users (id, name, email, mobile, created_on, modified_on,deleted) VALUES (1,'chetan','kasireddychetan@gmail.com','9000979804','2016-08-19 09:58:22',null,0)
INSERT INTO users (id, name, email, mobile, created_on, modified_on,deleted) VALUES (2,'prashant Baisla','prashant.baisla@practo.com','2016-08-19 09:58:22','2016-08-19 10:28:22',null,0)
INSERT INTO users (id, name, email, mobile, created_on, modified_on,deleted) VALUES (3,'Aditya Bhatia','aditya.bhatia@practo.com','999999999','2016-08-19 10:48:22',null,0);
INSERT INTO users(id, name, email, mobile, created_on, modified_on,deleted) VALUES (4, 'Test User', 'Testuser@mail.com', '1111111111', '2016-08-18 14:56:55', '2016-08-18 14:56:55', 0);

INSERT INTO property_type (id, type, created_on, modified_on, deleted) VALUES (1,'Apartment','2016-08-19 10:20:26','2016-08-23 21:00:38',0);
INSERT INTO property_type (id, type, created_on, modified_on, deleted) VALUES (2,'Villa','2016-08-19 10:20:26','2016-08-25 16:01:17',0);
INSERT INTO property_type  (id, type, created_on, modified_on, deleted) VALUES (3,'independent','2016-08-19 10:20:35','2016-08-23 20:07:12',0);
INSERT INTO property_type (id, type, created_on, modified_on, deleted) VALUES (4,'PentHouse',NULL,NULL,0);
INSERT INTO property_type (id, type, created_on, modified_on, deleted) VALUES (5,'Society','2016-08-23 21:04:03','2016-08-23 21:04:38',1);

INSERT INTO address (id, plot_no,property_name,locality, created_on, modified_on, deleted) VALUES (1,'L 605','Raj Lake View','Bilekahalli',NULL,NULL,0);

INSERT INTO address (id, plot_no,property_name,locality, created_on, modified_on, deleted) VALUES(2,'L 609','Reliable Woods','Hsr Layout',NULL,NULL,0),(3,'2-2-1072','Merugu Nilayam','BTM Layout','2016-08-23 22:26:19','2016-08-23 23:24:26',0),(5,'plot','propname','Hebbal','2016-08-26 08:59:47',NULL,0),(6,'plot','propname','Hebbal','2016-08-26 09:03:30',NULL,0);

INSERT INTO listings (id,posted_by_id,Title,address_id,property_id,no_beds,area,price,vacancy_for,furnished,room_for,possesion_date,posted_on,deleted,modified_on) VALUES (1,1,'Room available',1,2,3,1500,8000,1,'semi-furnished','male','2016-09-04 23:24:26','2016-08-29 23:24:26',0,null);

INSERT INTO listings (id,posted_by_id,Title,address_id,property_id,no_beds,area,price,vacancy_for,furnished,room_for,possesion_date,posted_on,deleted,modified_on) VALUES (2,2,'2 Rooms available',2,3,4,1500,8000,3,'semi-furnished','female','2016-09-04 23:24:26','2016-08-29 23:24:26',0,null);


INSERT INTO images (id, listings_id,image_path, created_on, modified_on, deleted) VALUES (1,1,'/accomfinder/lol','2016-08-19 10:20:26','2016-08-23 21:00:38',0);
INSERT INTO images (id, listings_id,image_path, created_on, modified_on, deleted) VALUES (2,1,'/accomfinder/lololol','2016-08-19 10:20:26','2016-08-25 16:01:17',0);
