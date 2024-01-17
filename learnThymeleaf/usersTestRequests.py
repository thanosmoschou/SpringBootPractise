"""
Author: Thanos Moschou
Description: This is a simple python script that sends requests to my users api. It is built to test the api.
Let's learn to use thymeleaf.
"""

import requests

url = "http://localhost:8080/users"

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)

print("*****READ PERSON BY NAME*****")
readPersonByIdResponse = requests.get(url + "/Thanos")
print(readPersonByIdResponse.text)

print("*****UPDATE PERSON BY NAME*****")
updatedPerson = {"name" : "Thanos", "age" : 25, "phone" : "6988888888"} #this object has the same name as before, the same name as before and the only thing that is different is the age (it was 20)
requests.put(url + "/" + updatedPerson["name"], json = updatedPerson)

readPersonByIdResponse = requests.get(url + "/Thanos") #check if user is updated by making a get request passing his name
print(readPersonByIdResponse.text)

print("*****CREATE PERSON*****")
createdPerson = {"name" : "Maria", "age" : 28, "phone" : "6977777777"}
requests.post(url, json = createdPerson)

readPersonByIdResponse = requests.get(url + "/" + createdPerson["name"]) #check if user is created by making a get request passing his name
print(readPersonByIdResponse.text)

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)

print("*****DELETE PERSON BY Name*****")
requests.delete(url + "/" + "Thanos")

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)