

create table prisoner --犯人信息
	(

	file_number char(18) not null, --档案号:441781AAAABBBBXXXX
	political_status		varchar(16), --政治面貌:群众，党员，团员，其他
	education_background		varchar(16),--学历：小学，初中，高中，大专，本科，其他
	name		varchar(16),--姓名
	birth_date  date,--出生日期：YYYY-MM-DD
	sex   varchar(2),--性别：男，女
	native_place  varchar(16),--籍贯：广东广州
	nationality  varchar(16),--民族：
	address  varchar(64),--家庭住址：广东省广州市番禺区大学城校区华南理工大学C10楼栋714
	family_background  varchar(16),--家庭情况：父母健在，父母双亡，独亲家庭
	blood_type  varchar(4),--血型：A,B,O,AB
	job   varchar(32),--工作：程序员，老师
	time_to_jail date,--入监时间：YYYY-MM-DD
	information_in_jail varchar(32), -- 入监信息：是否惯犯，行为恶劣
	register_in_jail varchar(16),-- 入监登记:送犯人过来的警官的名字
	  
	 primary key (file_number)
	);
create table term_information  --  刑期信息
	(
	file_number char(18) not null, --档案号:441781AAAABBBBXXXX
	prison_term  date,--刑期
	penalty_kind varchar(16),--刑种
	charge varchar(64), --罪名 
	foreign key (file_number) references prisoner
	on delete cascade
	);

create table medical_history  --  病史
	(
	file_number char(18) not null, --档案号:441781AAAABBBBXXXX
    illness_time    varchar(16), -- 病史.时间
    illness_symptom  varchar(16), -- 病症
	foreign key (file_number) references prisoner
	on delete cascade
	);
create table  rewords_punishments_information  --  奖惩信息
	(
	file_number char(18) not null, --档案号:441781AAAABBBBXXXX
    rpi_time    varchar(16), --奖惩信息.时间
    sentencing_condition varchar(16), --量刑情况
	rpi_type  varchar(16),-- 类型
	 foreign key (file_number) references prisoner
	 on delete cascade
	);
	   
create table  jail  --  监室 
	(
	
    jail_number    char(3) not null, --监室编号:714
    jail_equipment varchar(32), --设备维修登记检查 
	jail_check  varchar(32),-- 检查登记:5.29电灯坏，需更换
	jail_have_person  varchar(2),-- 是否有人 
	 primary key (jail_number),

	);

	




create table manager_information --管理人员基本信息
	(
	manager_file_number char(18) not null, --档案号:441781AAAABBBBXXXX
	manager_politics_status		varchar(16), --政治面貌:群众，党员，团员，其他
	manager_education_background		varchar(16),--学历：小学，初中，高中，大专，本科，其他
	manager_name	varchar(16),--姓名
	manager_birth_date  date,--出生日期：YYYY-MM-DD
	manager_sex  varchar(4),--性别：男，女
	manager_native_place  varchar(32),--籍贯：广东广州
	manager_nationality  varchar(16),--民族：
	manager_address  varchar(64),--家庭住址：广东省广州市番禺区大学城校区华南理工大学C10楼栋714
	manager_family_background  varchar(16),--家庭情况：父母健在，父母双亡，独亲家庭
	manager_blood_type varchar(4),--血型：A,B,O,AB
	manager_meidical_history varchar(32),--病史
	manager_work varchar(32),--工作
	manager_entry_time  date,  --入职时间
    manager_entry_information  varchar(32),  --入职信息
	primary key (manager_file_number)
	);



create table visit_person --探监人员基本信息
	(
	visit_person_id char(18) not null, --身份证号:441781AAAABBBBXXXX
	visit_person_name	varchar(8),--姓名
	visit_person_sex  varchar(2),--性别：男，女
	visit_times int,--到访次数
	relation_with_prisoner varchar(8),--与罪犯关系:血亲，朋友
	visit_person_remark varchar(32),--备注信息:无
	discipline_certainly varchar(32),--建设性管教:
	special_task varchar(32),--特殊任务:
	visit_person_number int, -- 探监人数
	visit_person_time date,--探监时间
	visit_person_record varchar(32),--探监记录档案
	visit_family_background varchar(32),--家庭背景
	history_of_infection varchar(32), -- 传染病史
	mental_illness varchar(32), -- 心理精神疾病
	criminal_record varchar(32), -- 犯罪记录
	primary key (visit_person_id),
	UNIQUE(visit_person_id)
	);


 create table user --管理人员基本信息
	(
	account varchar(32) not null, --档案号:441781AAAABBBBXXXX
	password varchar(32) not null, --政治面貌:群众，党员，团员，其他
	primary key (account)
	);