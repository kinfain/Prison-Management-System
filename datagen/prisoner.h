#pragma once
#include "common.h"


string genName()
{
	static const vector<string> m_xing =
	{
		"��", "Ǯ","��","��","��","��","֣","��","��","��","��",
		"ʩ","��","��","��","��","��","κ","��","ʷ","��","Ѧ",
		"��"
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



string genPoliticalStatus()
{
	static const vector<string> status =
	{
		"Ⱥ��","��Ա","��Ա","����"
	};
	return status[rand() % status.size()];
}

string genBirthdayDate()
{
	int year = rand() % 80 + 1900;
	int month = rand() % 12 + 1;
	int day = rand() % 28 + 1;
	string date = to_string(year) + "-" + to_string(month) + "-" + to_string(day);
	return date;
}

string genEducationBackground()
{
	static const vector<string> status =
	{
		"Сѧ","����","����","��ר","����","����","�о���","˶ʿ","��ʿ"
	};
	return status[rand() % status.size()];
}

string genSex()
{
	static const vector<string> status =
	{
		"��","Ů"
	};
	return status[rand() % status.size()];
}

string genNativePlace()
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


string genNationality()
{
	static const vector<string> status =
	{
		"��",
	};
	return status[rand() % status.size()];
}

string genAddress()
{
	return "";
}


string genFamilyBackground()
{
	static const vector<vector<string>>  status =
	{
		{"��ĸ����","��ĸ˫��","������","ĸ����"},
		{"�ѻ�", "δ��"},
	};
	return status[1][rand() % status[1].size()] + status[0][rand() % status[0].size()];
}


string genBloodType()
{
	static const vector<string> status =
	{
		"A","B","AB"
	};
	return status[rand() % status.size()];
}

string genJob()
{
	static const vector<string> status =
	{
		"����Ա","����Ա","��ʦ","�޹���","��������","up��"
	};
	return status[rand() % status.size()];
}



string genInformationInJail()
{
	return "Jail";
}


string genRegisterInJail()
{
	return "Jail";
}




string genFileNumber()
{
	string name;
	for (int i = 0; i < 18; i++)
		name += to_string(rand() % 10);
	return name;
}


struct prisoner
{
	string file_number;

	string political_status;
	string education_background;
	string name;
	string birth_date;
	string sex;
	string native_place;

	string nationality;
	string address;
	string family_background;
	string blood_type;

	string job;

	// 
	string time_to_jail;

	string information_in_jail; // �����Ϣ
	string register_in_jail; // ���Ǽ�
};



prisoner genPrisoner()
{
	prisoner p;

	p.name = genName();
	p.political_status = genPoliticalStatus();
	p.birth_date = genBirthdayDate();
	p.education_background = genEducationBackground();
	p.sex = genSex();
	p.native_place = genNativePlace();


	p.nationality = genNationality();
	p.address = p.native_place;// al

	p.family_background = genFamilyBackground();

	p.blood_type = genBloodType();
	p.job = genJob();

	p.file_number = genFileNumber();

	p.time_to_jail = genBirthdayDate(); // 
	p.information_in_jail = genInformationInJail();
	p.register_in_jail = genRegisterInJail();
	return p;
}


namespace gen
{

	string getPrisonerString()
	{

		prisoner p = genPrisoner();

		m_prisonerFileNumber.push_back(p.file_number);

		string s = string() + "insert into prisoner values(" +
			STR(p.file_number) + ", " +
			STR(p.political_status) + ", " +
			STR(p.education_background) + ", " +
			STR(p.name) + ", " +
			STR(p.birth_date) + ", " +
			STR(p.sex) + ", " +
			STR(p.native_place) + ", " +
			STR(p.nationality) + ", " +
			STR(p.address) + ", " +
			STR(p.family_background) + ", " +
			STR(p.blood_type) + ", " +
			STR(p.job) + ", " +
			STR(p.time_to_jail) + ", " +
			STR(p.information_in_jail) + ", " +
			STR(p.register_in_jail) +
			");";
		return s;
	}

}



