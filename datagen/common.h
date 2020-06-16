#pragma once
#include <string>
#include <iostream>
#include <string>
#include <vector>
#include <fstream>
using namespace std;

#define STR(str) "\'"+str+"\'"
#define NUM(num) std::to_string(num)


static std::vector<std::string> m_prisonerFileNumber;


static string genRandDate()
{
	int year = rand() % 80 + 1900;
	int month = rand() % 12 + 1;
	int day = rand() % 28 + 1;
	string date = to_string(year) + "-" + to_string(month) + "-" + to_string(day);
	return date;
}