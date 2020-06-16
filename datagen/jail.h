#pragma once
#include <unordered_set>
#include "common.h"

unordered_set<string> jailNumberSet;

static int num = 1;


struct Jail
{
	string jail_number;
	string jail_equipment;
	string jail_check;
	string jail_have_person;


	void gen()
	{
		jail_number = to_string(num++);
		if (jail_number.size() == 1)
			jail_number = "00" + jail_number;
		else if (jail_number.size() == 2)
			jail_number = "0" + jail_number;
		jail_equipment = "нч";
		jail_check = "нч";
		jail_have_person = "сп";
	}


};



namespace gen
{

	string getJail()
	{

		Jail jail;
		jail.gen();
		string s = string() + "insert into jail values(" +
			STR(jail.jail_number) + ", " +
			STR(jail.jail_equipment) + ", " +
			STR(jail.jail_check) + ", " +
			STR(jail.jail_have_person) +
			");";
		return s;
	}

}