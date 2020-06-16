#pragma once
#include "common.h"



struct visit_person
{
	static string genvisit_person_name()//��������������
	{
		static const vector<string> m_xing =
		{
			"��","Ǯ","��","��","��","��","֣","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","ʩ","��",
			"��","��","��","��","��","κ","��","��",
			"��","л","��","��","��","ˮ","�","��",
			"��","��","��","��","��","��","��","��",
			"³","Τ","��","��","��","��","��","��",
			"��","��","Ԭ","��","ۺ","��","ʷ","��",
			"��","��","�","Ѧ","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","ʱ","��","Ƥ","��","��","��",
			"��","��","Ԫ","��","��","��","ƽ","��",
			"��","��","��","��","Ҧ","��","տ","��",
			"��","ë","��","��","��","��","��","�",
			"��","��","��","��","̸","��","é","��",
			"��","��","��","��","��","ף","��","��",
			"��","��","��","��","ϯ","��","��","ǿ",
			"��","·","¦","Σ","��","ͯ","��","��",
			"÷","ʢ","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","֧","��","��","��","¬","Ī",
			"��","��","��","��","��","��","Ӧ","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","ʯ","��","��","ť","��",
			"��","��","��","��","��","½","��","��",
			"��","��","�","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","ɽ","��","��","��","�","��",
			"ȫ","ۭ","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","��","��","ղ","��","��",
			"Ҷ","��","˾","��","۬","��","��","��",
			"ӡ","��","��","��","��","ۢ","��","��",
			"��","��","��","��","׿","��","��","��",
			"��","��","��","�d","��","��","��","˫",
			"��","ݷ","��","��","̷","��","��","��",
			"��","��","��","��","Ƚ","��","۪","Ӻ",
			"�s","�","ɣ","��","�","ţ","��","ͨ",
			"��","��","��","��","ۣ","��","��","ũ",
			"��","��","ׯ","��","��","��","��","��",
			"Ľ","��","��","ϰ","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","��","��","��","»","��","��",
			"ŷ","�","��","��","ε","Խ","��","¡",
			"ʦ","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","ɳ","ؿ","��","��","��","��",
			"��","��","��","��","��","��","��","��",
			"��","��","Ȩ","��","��","��","��","��",

			"��ٹ","˾��","�Ϲ�","ŷ��",
			"�ĺ�","���","����","����",
			"����","�ʸ�","ξ��","����",
			"�̨","��ұ","����","���",
			"����","����","̫��","����",
			"����","����","��ԯ","���",
			"����","����","����","Ľ��",
			"����","����","˾ͽ","˾��",
			"آ��","˾��","�붽","�ӳ�",
			"���","��ľ","����","����",
			"���","����","����","����",
			"�ذ�","�й�","�׸�","����",
			"����","�Ʒ�","��۳","Ϳ��",
			"�θ�","����","����","����",
			"����"
		};

		static const vector<string> m_ming =
		{
			"һ","��","��","��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��","��","��","��",
			"��","��","��","̩","̫","��","��","��","��","��","��",
		};

		string name;
		name += m_xing[rand() % m_xing.size()];


		bool double_name;
		if (rand() % 2 == 1)
			double_name = true;
		else
			double_name = false;

		name += m_ming[rand() % m_ming.size()];
		if (double_name)
		{
			name += m_ming[rand() % m_ming.size()];
		}
		return name;
	}

	static string genvisit_person_sex()//�����������Ա�
	{
		static const vector<string> status =
		{
			"��","Ů"
		};
		return status[rand() % status.size()];
	}


	static int genvisit_times()//���������ߵ��ô���
	{
		int status = rand() % 100;
		return status;
	}

	static string genvisit_person_id()//�������������֤��
	{
		string name;
		for (int i = 0; i < 18; i++)
			name += to_string(rand() % 10);
		return name;
	}

	static string genrelation_with_prisoner()//�������ﷸ��ϵ
	{
		static const vector<string> status =
		{
			"ֱϵѪ��","��ϵѪ��","����","������ϵ"
		};
		return status[rand() % status.size()];
	}

	static string genvisit_person_remark()//���ɱ�ע��Ϣ
	{
		static const vector<string> status =
		{
			"��","�����з���ǰ��","����Ϊxx��˾Ա��","����Ϊ�������"
		};
		return status[rand() % status.size()];
	}

	static string gendiscipline_certainly()//���ɽ����Թܽ�
	{
		static const vector<string> status =
		{
			"��","��������","ͬ���˹�ͨ����","Ϊ�����������赼"
		};
		return status[rand() % status.size()];
	}

	static string genspecial_task()//������������
	{
		static const vector<string> status =
		{
			"��","��ȡ������Ϣ","�߷�����"
		};
		return status[rand() % status.size()];
	}

	static int genvisit_person_number()//���ɵ�������
	{
		int status = rand() % 5;
		return status;
	}

	static string genvisit_person_time()//����̽��ʱ��
	{
		int year = rand() % 80 + 1900;
		int month = rand() % 12 + 1;
		int day = rand() % 28 + 1;
		string date = to_string(year) + "-" + to_string(month) + "-" + to_string(day);
		return date;
	}

	static string genvisit_person_record()//����̽�ü�¼����
	{
		static const vector<string> status =
		{
			"���쳣","����С�¹�","���������¹�"
		};
		return status[rand() % status.size()];
	}

	static string genhistory_of_infection()//���ɴ�Ⱦ��ʷ
	{
		static const vector<string> status =
		{
			"�޴�Ⱦ��ʷ","�����в�ʷ","�¹ڷ��׻���","���������в�ѧʷ"
		};
		return status[rand() % status.size()];
	}

	static string genvisit_family_background()//���ɼ�ͥ����
	{
		static const vector<vector<string>>  status =
		{
			{"��ĸ����","��ĸ˫��","���׽���","ĸ�׽���"},
			{"�ѻ�", "δ��"},
		};
		return status[1][rand() % status[1].size()] + status[0][rand() % status[0].size()];
	}

	static string genmental_illness()//��������������
	{
		static const vector<string> status =
		{
			"������������","��������"
		};
		return status[rand() % status.size()];
	}

	static string gencriminal_record()//���ɷ����¼
	{
		static const vector<string> status =
		{
			"�޷����¼","�з���ǰ��"
		};
		return status[rand() % status.size()];
	}
	string visit_person_id;//���������֤��
	string visit_person_name;//����������
	string visit_person_sex;//�������Ա�
	int visit_times;//�����ߵ��ô���
	string relation_with_prisoner;//���ﷸ��ϵ
	string visit_person_remark;//��ע��Ϣ
	string discipline_certainly;//�����Թܽ�
	string special_task;//��������
	int visit_person_number;//��������
	string visit_person_time;//����ʱ��
	string visit_person_record;//̽�ü�¼����
	string history_of_infection;//��Ⱦ��ʷ
	string visit_family_background;//��ͥ����
	string mental_illness;//����������
	string criminal_record;//�����¼

	static visit_person gen_visit_person()
	{
		visit_person p;

		p.visit_person_name = genvisit_person_name();
		p.visit_person_sex = genvisit_person_sex();
		p.visit_times = genvisit_times();
		p.visit_person_id = genvisit_person_id();
		p.relation_with_prisoner = genrelation_with_prisoner();
		p.visit_person_remark = genvisit_person_remark();
		p.discipline_certainly = gendiscipline_certainly();
		p.special_task = genspecial_task();
		p.visit_person_number = genvisit_person_number();
		p.visit_person_time = genvisit_person_time();
		p.visit_person_record = genvisit_person_record();
		p.history_of_infection = genhistory_of_infection();
		p.visit_family_background = genvisit_family_background();
		p.mental_illness = genmental_illness();
		p.criminal_record = gencriminal_record();
		return p;
	}
};




namespace gen
{

	static string getVisitPerson()
	{

		visit_person p;
		p = visit_person::gen_visit_person();
		string s = string() + "insert into visit_person values(" +
			STR(p.visit_person_id) + ", " +
			STR(p.visit_person_name) + ", " +
			STR(p.visit_person_sex) + ", " +
			NUM(p.visit_times) + ", " +
			STR(p.relation_with_prisoner) + ", " +
			STR(p.visit_person_remark) + ", " +
			STR(p.discipline_certainly) + ", " +
			STR(p.special_task) + ", " +
			NUM(p.visit_person_number) + ", " +
			STR(p.visit_person_time) + ", " +
			STR(p.visit_person_record) + ", " +
			STR(p.visit_family_background) + ", " +
			STR(p.history_of_infection) + ", " +
			STR(p.mental_illness) + ", " +
			STR(p.criminal_record) +
			");";
		return s;
	}

}