

create table prisoner --������Ϣ
	(

	file_number char(18) not null, --������:441781AAAABBBBXXXX
	political_status		varchar(16), --������ò:Ⱥ�ڣ���Ա����Ա������
	education_background		varchar(16),--ѧ����Сѧ�����У����У���ר�����ƣ�����
	name		varchar(16),--����
	birth_date  date,--�������ڣ�YYYY-MM-DD
	sex   varchar(2),--�Ա��У�Ů
	native_place  varchar(16),--���᣺�㶫����
	nationality  varchar(16),--���壺
	address  varchar(64),--��ͥסַ���㶫ʡ�����з�خ����ѧ��У����������ѧC10¥��714
	family_background  varchar(16),--��ͥ�������ĸ���ڣ���ĸ˫�������׼�ͥ
	blood_type  varchar(4),--Ѫ�ͣ�A,B,O,AB
	job   varchar(32),--����������Ա����ʦ
	time_to_jail date,--���ʱ�䣺YYYY-MM-DD
	information_in_jail varchar(32), -- �����Ϣ���Ƿ�߷�����Ϊ����
	register_in_jail varchar(16),-- ���Ǽ�:�ͷ��˹����ľ��ٵ�����
	  
	 primary key (file_number)
	);
create table term_information  --  ������Ϣ
	(
	file_number char(18) not null, --������:441781AAAABBBBXXXX
	prison_term  date,--����
	penalty_kind varchar(16),--����
	charge varchar(64), --���� 
	foreign key (file_number) references prisoner
	on delete cascade
	);

create table medical_history  --  ��ʷ
	(
	file_number char(18) not null, --������:441781AAAABBBBXXXX
    illness_time    varchar(16), -- ��ʷ.ʱ��
    illness_symptom  varchar(16), -- ��֢
	foreign key (file_number) references prisoner
	on delete cascade
	);
create table  rewords_punishments_information  --  ������Ϣ
	(
	file_number char(18) not null, --������:441781AAAABBBBXXXX
    rpi_time    varchar(16), --������Ϣ.ʱ��
    sentencing_condition varchar(16), --�������
	rpi_type  varchar(16),-- ����
	 foreign key (file_number) references prisoner
	 on delete cascade
	);
	   
create table  jail  --  ���� 
	(
	
    jail_number    char(3) not null, --���ұ��:714
    jail_equipment varchar(32), --�豸ά�޵ǼǼ�� 
	jail_check  varchar(32),-- ���Ǽ�:5.29��ƻ��������
	jail_have_person  varchar(2),-- �Ƿ����� 
	 primary key (jail_number),

	);

	




create table manager_information --������Ա������Ϣ
	(
	manager_file_number char(18) not null, --������:441781AAAABBBBXXXX
	manager_politics_status		varchar(16), --������ò:Ⱥ�ڣ���Ա����Ա������
	manager_education_background		varchar(16),--ѧ����Сѧ�����У����У���ר�����ƣ�����
	manager_name	varchar(16),--����
	manager_birth_date  date,--�������ڣ�YYYY-MM-DD
	manager_sex  varchar(4),--�Ա��У�Ů
	manager_native_place  varchar(32),--���᣺�㶫����
	manager_nationality  varchar(16),--���壺
	manager_address  varchar(64),--��ͥסַ���㶫ʡ�����з�خ����ѧ��У����������ѧC10¥��714
	manager_family_background  varchar(16),--��ͥ�������ĸ���ڣ���ĸ˫�������׼�ͥ
	manager_blood_type varchar(4),--Ѫ�ͣ�A,B,O,AB
	manager_meidical_history varchar(32),--��ʷ
	manager_work varchar(32),--����
	manager_entry_time  date,  --��ְʱ��
    manager_entry_information  varchar(32),  --��ְ��Ϣ
	primary key (manager_file_number)
	);



create table visit_person --̽����Ա������Ϣ
	(
	visit_person_id char(18) not null, --���֤��:441781AAAABBBBXXXX
	visit_person_name	varchar(8),--����
	visit_person_sex  varchar(2),--�Ա��У�Ů
	visit_times int,--���ô���
	relation_with_prisoner varchar(8),--���ﷸ��ϵ:Ѫ�ף�����
	visit_person_remark varchar(32),--��ע��Ϣ:��
	discipline_certainly varchar(32),--�����Թܽ�:
	special_task varchar(32),--��������:
	visit_person_number int, -- ̽������
	visit_person_time date,--̽��ʱ��
	visit_person_record varchar(32),--̽���¼����
	visit_family_background varchar(32),--��ͥ����
	history_of_infection varchar(32), -- ��Ⱦ��ʷ
	mental_illness varchar(32), -- �����񼲲�
	criminal_record varchar(32), -- �����¼
	primary key (visit_person_id),
	UNIQUE(visit_person_id)
	);


 create table user --������Ա������Ϣ
	(
	account varchar(32) not null, --������:441781AAAABBBBXXXX
	password varchar(32) not null, --������ò:Ⱥ�ڣ���Ա����Ա������
	primary key (account)
	);