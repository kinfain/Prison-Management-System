#pragma once
#include "common.h"



struct visit_person
{
	static string genvisit_person_name()//生成来访者姓名
	{
		static const vector<string> m_xing =
		{
			"赵","钱","孙","李","周","吴","郑","王",
			"冯","陈","褚","卫","蒋","沈","韩","杨",
			"朱","秦","尤","许","何","吕","施","张",
			"孔","曹","严","华","金","魏","陶","姜",
			"戚","谢","邹","喻","柏","水","窦","章",
			"云","苏","潘","葛","奚","范","彭","郎",
			"鲁","韦","昌","马","苗","凤","花","方",
			"俞","任","袁","柳","酆","鲍","史","唐",
			"费","廉","岑","薛","雷","贺","倪","汤",
			"滕","殷","罗","毕","郝","邬","安","常",
			"乐","于","时","傅","皮","卞","齐","康",
			"伍","余","元","卜","顾","孟","平","黄",
			"和","穆","萧","尹","姚","邵","湛","汪",
			"祁","毛","禹","狄","米","贝","明","臧",
			"计","伏","成","戴","谈","宋","茅","庞",
			"熊","纪","舒","屈","项","祝","董","梁",
			"杜","阮","蓝","闵","席","季","麻","强",
			"贾","路","娄","危","江","童","颜","郭",
			"梅","盛","林","刁","钟","徐","邱","骆",
			"高","夏","蔡","田","樊","胡","凌","霍",
			"虞","万","支","柯","昝","管","卢","莫",
			"经","房","裘","缪","干","解","应","宗",
			"丁","宣","贲","邓","郁","单","杭","洪",
			"包","诸","左","石","崔","吉","钮","龚",
			"程","嵇","邢","滑","裴","陆","荣","翁",
			"荀","羊","於","惠","甄","曲","家","封",
			"芮","羿","储","靳","汲","邴","糜","松",
			"井","段","富","巫","乌","焦","巴","弓",
			"牧","隗","山","谷","车","侯","宓","蓬",
			"全","郗","班","仰","秋","仲","伊","宫",
			"宁","仇","栾","暴","甘","钭","厉","戎",
			"祖","武","符","刘","景","詹","束","龙",
			"叶","幸","司","韶","郜","黎","蓟","薄",
			"印","宿","白","怀","蒲","邰","从","鄂",
			"索","咸","籍","赖","卓","蔺","屠","蒙",
			"池","乔","阴","鬱","胥","能","苍","双",
			"闻","莘","党","翟","谭","贡","劳","逄",
			"姬","申","扶","堵","冉","宰","郦","雍",
			"卻","璩","桑","桂","濮","牛","寿","通",
			"边","扈","燕","冀","郏","浦","尚","农",
			"温","别","庄","晏","柴","瞿","阎","充",
			"慕","连","茹","习","宦","艾","鱼","容",
			"向","古","易","慎","戈","廖","庾","终",
			"暨","居","衡","步","都","耿","满","弘",
			"匡","国","文","寇","广","禄","阙","东",
			"欧","殳","沃","利","蔚","越","夔","隆",
			"师","巩","厍","聂","晁","勾","敖","融",
			"冷","訾","辛","阚","那","简","饶","空",
			"曾","毋","沙","乜","养","鞠","须","丰",
			"巢","关","蒯","相","查","后","荆","红",
			"游","竺","权","逯","盖","益","桓","公",

			"万俟","司马","上官","欧阳",
			"夏侯","诸葛","闻人","东方",
			"赫连","皇甫","尉迟","公羊",
			"澹台","公冶","宗政","濮阳",
			"淳于","单于","太叔","申屠",
			"公孙","仲孙","轩辕","令狐",
			"钟离","宇文","长孙","慕容",
			"鲜于","闾丘","司徒","司空",
			"丌官","司寇","仉督","子车",
			"颛孙","端木","巫马","公西",
			"漆雕","乐正","壤驷","公良",
			"拓跋","夹谷","宰父","谷梁",
			"晋楚","闫法","汝鄢","涂钦",
			"段干","百里","东郭","南门",
			"呼延"
		};

		static const vector<string> m_ming =
		{
			"一","二","三","四","五","民","龙","徐","坤","庆","国",
			"聪","敏","可","新","机","鹏","生","乃","梦","弯","力",
			"利","倍","爱","泰","太","钛","亮","老","淦","芜","呼",
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

	static string genvisit_person_sex()//生成来访者性别
	{
		static const vector<string> status =
		{
			"男","女"
		};
		return status[rand() % status.size()];
	}


	static int genvisit_times()//生成来访者到访次数
	{
		int status = rand() % 100;
		return status;
	}

	static string genvisit_person_id()//生成来访者身份证号
	{
		string name;
		for (int i = 0; i < 18; i++)
			name += to_string(rand() % 10);
		return name;
	}

	static string genrelation_with_prisoner()//生成与罪犯关系
	{
		static const vector<string> status =
		{
			"直系血亲","旁系血亲","朋友","其他关系"
		};
		return status[rand() % status.size()];
	}

	static string genvisit_person_remark()//生成备注信息
	{
		static const vector<string> status =
		{
			"无","该人有犯罪前科","该人为xx公司员工","该人为外国国籍"
		};
		return status[rand() % status.size()];
	}

	static string gendiscipline_certainly()//生成建设性管教
	{
		static const vector<string> status =
		{
			"无","教育犯人","同犯人沟通交流","为犯人做心理疏导"
		};
		return status[rand() % status.size()];
	}

	static string genspecial_task()//生成特殊任务
	{
		static const vector<string> status =
		{
			"无","套取犯人信息","策反犯人"
		};
		return status[rand() % status.size()];
	}

	static int genvisit_person_number()//生成到访人数
	{
		int status = rand() % 5;
		return status;
	}

	static string genvisit_person_time()//生成探访时间
	{
		int year = rand() % 80 + 1900;
		int month = rand() % 12 + 1;
		int day = rand() % 28 + 1;
		string date = to_string(year) + "-" + to_string(month) + "-" + to_string(day);
		return date;
	}

	static string genvisit_person_record()//生成探访记录档案
	{
		static const vector<string> status =
		{
			"无异常","出现小事故","出现严重事故"
		};
		return status[rand() % status.size()];
	}

	static string genhistory_of_infection()//生成传染病史
	{
		static const vector<string> status =
		{
			"无传染病史","有流感病史","新冠肺炎患者","有其他流行病学史"
		};
		return status[rand() % status.size()];
	}

	static string genvisit_family_background()//生成家庭背景
	{
		static const vector<vector<string>>  status =
		{
			{"父母健在","父母双亡","父亲健在","母亲健在"},
			{"已婚", "未婚"},
		};
		return status[1][rand() % status[1].size()] + status[0][rand() % status[0].size()];
	}

	static string genmental_illness()//生成心理健康疾病
	{
		static const vector<string> status =
		{
			"无心理健康问题","有心理疾病"
		};
		return status[rand() % status.size()];
	}

	static string gencriminal_record()//生成犯罪记录
	{
		static const vector<string> status =
		{
			"无犯罪记录","有犯罪前科"
		};
		return status[rand() % status.size()];
	}
	string visit_person_id;//来访者身份证号
	string visit_person_name;//来访者姓名
	string visit_person_sex;//来访者性别
	int visit_times;//来访者到访次数
	string relation_with_prisoner;//与罪犯关系
	string visit_person_remark;//备注信息
	string discipline_certainly;//建设性管教
	string special_task;//特殊任务
	int visit_person_number;//到访人数
	string visit_person_time;//到访时间
	string visit_person_record;//探访记录档案
	string history_of_infection;//传染病史
	string visit_family_background;//家庭背景
	string mental_illness;//心理健康疾病
	string criminal_record;//犯罪记录

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