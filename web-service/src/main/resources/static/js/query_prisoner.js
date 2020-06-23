                            document.getElementById("query_button").onclick = function () {
                                var v = document.getElementById("prisoner_name_input").value;
                                var url = "/query/prisoner_info2?name=" + v + "&sex=" + document.getElementById("prisoner_sex_input").value + "&birth_date=" + document.getElementById("prisoner_birth_date_input").value + "&blood_type=" + document.getElementById("prisoner_blood_type_input").value;
                                window.location.href = url;
                            }
