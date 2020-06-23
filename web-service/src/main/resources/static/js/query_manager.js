                                document.getElementById("query_button").onclick = function () {
                                    var v = document.getElementById("manager_name_input").value;
                                    var ref_char = '&';
                                    var url = "/query/manager_info2?manager_name=" + v + ref_char +"manager_sex=" + document.getElementById("manager_sex_input").value + ref_char +"manager_birth_date=" + document.getElementById("manager_birth_date_input").value + ref_char +"manager_blood_type=" + document.getElementById("manager_blood_type_input").value;
                                    window.location.href = url;

                                }