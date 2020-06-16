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
			"无","过敏史","手术史","遗传病史","传染病史"
		};
		return status[rand() % status.size()];
	}


	static string genmanager_politics_status()
	{
		static const vector<string> status =
		{
			"群众","党员","团员","其他"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_work()
	{
		static const vector<string> status =
		{
			"狱警","监狱长","厨师","维修工","医生"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_education_background()
	{
		static const vector<string> status =
		{
			"小学","初中","高中","大专","本科","其他","研究生","硕士","博士"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_nationality()
	{
		static const vector<string> status =
		{
			"汉","蒙古族", "藏族", "苗族", "壮族", "回族", "维吾尔族",
			"彝族", "布依族", "朝鲜族", "侗族", "白族", "哈尼族",
			"傣族", "傈僳族", "畲族", "拉祜族", "满族", "瑶族",
			"土家族", "哈萨克族", "黎族", "佤族", "高山族", "水族",
			"东乡族", "景颇族", "土族", "仫佬族", "布朗族", "毛南族",
			"锡伯族", "普米族", "纳西族", "柯尔克孜族", "达斡尔族",
			"羌族", "撒拉族", "仡佬族", "阿昌族", "塔吉克族", "怒族",
			"俄罗斯族", "德昂族", "裕固族", "塔塔尔族", "鄂伦春族",
			"门巴族", "基诺族", "乌孜别克族", "鄂温克族", "保安族",
			"京族", "独龙族", "赫哲族", "珞巴族"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_name()
	{
		static const vector<string> m_xing =
		{
			"赵", "钱","孙","李","王","陈","郑","吴","周","何","吕",
			"施","孔","曹","严","华","金","魏","方","史","朱","薛",
			"蔡","刘","钟"
		};

		static const vector<string> m_ming =
		{
			"一","二","三","四","五","民","龙","徐","坤","庆","国",
			"聪","敏","可","新","机","鹏","生","乃","梦","弯","力",
			"利","倍","爱","泰","太","钛","亮","老","淦","芜","呼",
			"飞","狗","蛋","奥","力","给"
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
			"男","女"
		};
		return status[rand() % status.size()];
	}

	static string genmanager_family()
	{
		static const vector<vector<string>>  status =
		{
			{"父母健在","父母双亡","父健在","母健在"},
			{"已婚", "未婚"},
		};
		return status[1][rand() % status[1].size()] + status[0][rand() % status[0].size()];
	}

	static string genmanager_address()
	{
		return "广东省广州市";
	}

	static string genmanager_native_place()
	{
		static const vector<string> p =
		{
			"广东省","四川省","江西省"
		};
		static const vector<vector<string>> s =
		{
			{"广州市","深圳市","珠海市","汕头市","佛山市"},
			{"成都市","绵阳市","自贡市","泸州市","广元市"},
			{"南昌市","九江市","宜春市","上饶市"},
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
		p.manager_entry_information = "无";
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
