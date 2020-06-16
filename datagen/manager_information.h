#pragma once
#include"common.h"



struct manager_information
{
	static string genmanager_blood_type()
	{
		static const vector<string> status =
		{
			"A","B","AB"
		};
		return status[rand() % status.size()];
	}


	static string genmanager_meidical_history()
	{
		static const vector<string> status =
		{
			"��","����ʷ","����ʷ","�Ŵ���ʷ","��Ⱦ��ʷ"
		};
		return status[rand() % status.size()];
	}


	static string genmanager_politics_status()
	{
		static const vector<string> status =
		{
			"Ⱥ��","��Ա","��Ա","����"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_work()
	{
		static const vector<string> status =
		{
			"����","������","��ʦ","ά�޹�","ҽ��"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_education_background()
	{
		static const vector<string> status =
		{
			"Сѧ","����","����","��ר","����","����","�о���","˶ʿ","��ʿ"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_nationality()
	{
		static const vector<string> status =
		{
			"��","�ɹ���", "����", "����", "׳��", "����", "ά�����",
			"����", "������", "������", "����", "����", "������",
			"����", "������", "���", "������", "����", "����",
			"������", "��������", "����", "����", "��ɽ��", "ˮ��",
			"������", "������", "����", "������", "������", "ë����",
			"������", "������", "������", "�¶�������", "���Ӷ���",
			"Ǽ��", "������", "������", "������", "��������", "ŭ��",
			"����˹��", "�°���", "ԣ����", "��������", "���״���",
			"�Ű���", "��ŵ��", "���α����", "���¿���", "������",
			"����", "������", "������", "�����"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_name()
	{
		static const vector<string> m_xing =
		{
			"��", "Ǯ","��","��","��","��","֣","��","��","��","��",
			"ʩ","��","��","��","��","��","κ","��","ʷ","��","Ѧ",
			"��","��","��"
		};

		static const vector<string> m_ming =
		{
			"һ","��","��","��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��","��","��","��","��",
			"��","��","��","̩","̫","��","��","��","��","��","��",
			"��","��","��","��","��","��"
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

	static string genmanager_birth_date()
	{
		int year = rand() % 80 + 1900;
		int month = rand() % 12 + 1;
		int day = rand() % 28 + 1;
		string date = to_string(year) + "-" + to_string(month) + "-" + to_string(day);
		return date;
	}

	static string genmanager_sex()
	{
		static const vector<string> status =
		{
			"��","Ů"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_family()
	{
		static const vector<vector<string>>  status =
		{
			{"��ĸ����","��ĸ˫��","������","ĸ����"},
			{"�ѻ�", "δ��"},
		};
		return status[1][rand() % status[1].size()] + status[0][rand() % status[0].size()];
	}

	static string genmanager_address()
	{
		return "�㶫ʡ������";
	}

	static string genmanager_native_place()
	{
		static const vector<string> p =
		{
			"�㶫ʡ","�Ĵ�ʡ","����ʡ"
		};
		static const vector<vector<string>> s =
		{
			{"������","������","�麣��","��ͷ��","��ɽ��"},
			{"�ɶ���","������","�Թ���","������","��Ԫ��"},
			{"�ϲ���","�Ž���","�˴���","������"},
		};
		int p_i = rand() % p.size();
		return p[p_i] + s[p_i][rand() % s.size()];
	}

	static string genFileNumber()
	{
		string name;
		for (int i = 0; i < 18; i++)
			name += to_string(rand() % 10);
		return name;
	}

	string manager_file_number;
	string manager_politics_status;
	string manager_education_background;
	string manager_name;
	string manager_birth_date;
	string manager_sex;
	string manager_native_place;
	string manager_nationality;
	string manager_address;

	string manager_family_background;

	string manager_blood_type;
	string manager_meidical_history;
	string manager_work;
	string manager_entry_time;
	string manager_entry_information;

	static manager_information genmanager_information()
	{
		manager_information p;
		p.manager_file_number = genFileNumber();
		p.manager_blood_type = genmanager_blood_type();
		p.manager_meidical_history = genmanager_meidical_history();
		p.manager_politics_status = genmanager_politics_status();
		p.manager_work = genmanager_work();
		p.manager_education_background = genmanager_education_background();
		p.manager_nationality = genmanager_nationality();
		p.manager_name = genmanager_name();
		p.manager_birth_date = genmanager_birth_date();
		p.manager_sex = genmanager_sex();
		p.manager_family_background = genmanager_family();
		p.manager_address = genmanager_address();
		p.manager_native_place = genmanager_native_place();
		p.manager_entry_time = genmanager_birth_date();
		p.manager_entry_information = "��";
		return p;
	}
};



namespace gen
{

	static string getManagerInformationString()
	{

		manager_information p;
		p = manager_information::genmanager_information();
		string s = string() + "insert into manager_information values(" +
			STR(p.manager_file_number) + ", " +
			STR(p.manager_politics_status) + ", " +
			STR(p.manager_education_background) + ", " +
			STR(p.manager_name) + ", " +
			STR(p.manager_birth_date) + ", " +
			STR(p.manager_sex) + ", " +
			STR(p.manager_native_place) + ", " +
			STR(p.manager_nationality) + ", " +
			STR(p.manager_address) + ", " +
			STR(p.manager_family_background) + ", " +
			STR(p.manager_blood_type) + ", " +
			STR(p.manager_meidical_history) + ", " +
			STR(p.manager_work) + ", " +
			STR(p.manager_entry_time) + ", " +
			STR(p.manager_entry_information)
			");";
		return s;
	}

}
