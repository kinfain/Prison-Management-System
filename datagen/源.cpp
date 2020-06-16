
//medical_history aaa()
//{
//	medical_history p;
//	p.prison_term = genBirthdayDate(); //
//	p.penalty_kind = genPenaltyKind();
//	p.charge = genCharge();
//
//}


#include "common.h"
#include "prisoner.h"
#include "jail.h"

#include "manager_information.h"
#include "visit_person.h"
#include "rewords_punishments_information.h"
#include "medical_history.h"
#include "term_information.h"
#include "user.h"

int main()
{

	ofstream ofs("data.sql");

	for (int i = 0; i < 1000; i++)
		ofs << gen::getPrisonerString() << std::endl;
	for (int i = 0; i < 200; i++)
		ofs << gen::getJail() << std::endl;

	for (int i = 0; i < 100; i++)
		ofs << gen::getVisitPerson() << std::endl;
	for (int i = 0; i < 100; i++)
		ofs << gen::getManagerInformationString() << std::endl;

	for (int i = 0; i < 1000; i++)
		ofs << gen::getRewordsPunishmentsInformationString() << std::endl;

	for (int i = 0; i < 1000; i++)
		ofs << gen::getMedicalHistoryString() << std::endl;

	for (int i = 0; i < 1000; i++)
		ofs << gen::getTermInformationString() << std::endl;



	{
		user p;
		p.account = "root";
		p.password = "123";
		string s = string() + "insert into user values(" +
			STR(p.account) + ", " +
			STR(p.password)
			");";
		ofs << s << std::endl;
	}


	//for (int i = 1; i <= 7; i++)
	//{
	//	for (int j = 0; j <= 99; j++)
	//	{
	//		Jail jail;
	//		jail.gen(i * 100 + j);

	//		string s = string() + "insert into jail values(" +
	//			STR(jail.jail_number) + ", " +
	//			STR(jail.jail_equipment) + ", " +
	//			STR(jail.jail_check) + ", " +
	//			STR(jail.jail_have_person) +
	//			");";
	//		ofs << s << std::endl;
	//	}
	//}


}

