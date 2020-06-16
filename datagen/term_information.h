#pragma once

#include "common.h"



struct term_information
{
	string  file_number;
	string	prison_term;
	string	penalty_kind;
	string	charge;





};

term_information gen_term_information()
{
	term_information p;
	p.file_number = m_prisonerFileNumber[rand() % m_prisonerFileNumber.size()];
	p.prison_term = genRandDate();
	p.penalty_kind = "нч";
	p.charge = "нч";
	return p;
}



namespace gen
{

	string getTermInformationString()
	{
		auto p = gen_term_information();
		string s = string() + "insert into term_information values(" +
			STR(p.file_number) + ", " +
			STR(p.prison_term) + ", " +
			STR(p.penalty_kind) + ", " +
			STR(p.charge) +
			");";
		return s;
	}

}