set search_path to estate;

INSERT INTO role(code, name) VALUES ('ADMIN','admin');
INSERT INTO role(code, name) VALUES ('USER','user');

INSERT INTO users(fullname, password, status, username) VALUES ('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'admin');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn A','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'user');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn B','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'userb');
INSERT INTO users(fullname, password, status, username) VALUES ('Nguyễn Văn C','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'userc');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);
INSERT INTO user_role(user_id, role_id) VALUES (3,2);
INSERT INTO user_role(user_id, role_id) VALUES (4,2);

insert into district(code,name) values('760', 'Quận 1');
insert into district(code,name) values('761', 'Quận 12');
insert into district(code,name) values('762', 'Quận Thủ Đức');
insert into district(code,name) values('763', 'Quận 9');
insert into district(code,name) values('764', 'Quận Gò Vấp');
insert into district(code,name) values('765', 'Quận Bình Thạnh');
insert into district(code,name) values('766', 'Quận Tân Bình');
insert into district(code,name) values('767', 'Quận Tân Phú');
insert into district(code,name) values('768', 'Quận Phú Nhuận');
insert into district(code,name) values('769', 'Quận 2');
insert into district(code,name) values('770', 'Quận 3');
insert into district(code,name) values('771', 'Quận 10');
insert into district(code,name) values('772', 'Quận 11');
insert into district(code,name) values('773', 'Quận 4');
insert into district(code,name) values('774', 'Quận 5');
insert into district(code,name) values('775', 'Quận 6');
insert into district(code,name) values('776', 'Quận 8');
insert into district(code,name) values('777', 'Quận Bình Tân');
insert into district(code,name) values('778', 'Quận 7');
insert into district(code,name) values('783', 'Huyện Củ Chi');
insert into district(code,name) values('784', 'Huyện Hóc Môn');
insert into district(code,name) values('785', 'Huyện Bình Chánh');
insert into district(code,name) values('786', 'Huyện Nhà Bè');
insert into district(code,name) values('787', 'Huyện Cần Giờ');

