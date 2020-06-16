#pragma once

#include "common.h"





struct medical_history
{
	string  file_number;
	string	illness_time;
	string	illness_symptom;
};


medical_history gen_medical_history()
{
	medical_history p;
	p.file_number = m_prisonerFileNumber[rand() % m_prisonerFileNumber.size()];
	p.illness_time = genRandDate();
	p.illness_symptom = "нч";
	return p;
}



namespace gen
{

	string getMedicalHistoryString()
	{
		auto p = gen_medical_history();
		string s = string() + "insert into medical_history values(" +
			STR(p.file_number) + ", " +
			STR(p.illness_time) + ", " +
			STR(p.illness_symptom) +
			");";
		return s;
	}

}