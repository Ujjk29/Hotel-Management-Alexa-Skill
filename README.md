# Hotel Management Alexa Skill

## Index

## Introduction
Hotel Management Alexa skill is able to provde hotel specific services like ordering food, requesting cleaning services ... etc for the hotel customers. Currently the skill supports taking order from the customers. If customers know what they want to order they can directly order it. Otherwise the skill will use multi-turn model to decide what you want to eat. You can also schedule your order to specific time.

## Problem Statement
Hotel guests need to call the hotel receptions to put their requests like foor orders, room service, laundry services ... etc. And then receptionist forward their requests to different department of hotel. This whole process takes precious time of hotel. And to handle simultaneous calls from guests require both human resources and captial. So our aim is to solve this problem by replacing old telephones with our Alexa Skill. Now the requests from customers will directly forwarded to the specific department of the hotel based on request. This will save hotel captial and human resources.

## Requirements
1. **Ordering Food**
    1. **Hotel Customer** can **place order** on what to eat through Alexa. Skill must be **multi-turn**, so that skill can help customer in choosing the right food that is available.
    2. HMAS must be able to **record the customer’s order** in text form (preferably in Hotel’s Website, but I will  go with Google Sheets for now). And this record must be available to **Restaurant Captain** (or Chef Manager).
    3. Captain can confirm the order, and HMAS must notify the customer that **their order is acknowledged** through the same Alexa Skill.
    4. After food is processed, **captain can modify the google sheet** and that sheet can automatically **notify the customer through Alexa** (can use some other Lambda function to read sheet and notify the HMAS) that their food is processed and will reach to their room by 4-5 mins.
    5. Customer can also **tip (Amazon Pay) their waiter** for bringing the hot food.
2. **Laundry Service**
    1. Customer **can request** for laundry services.
    2. Skill must be **multi-turn** so that laundry service knows **meta-information about the request**, like **how many clothes** are there, what **type of clothes** are there, when to **pick-up** and when to **drop-off** clothes. This meta-information will help Laundry services to charge the customer. 
    3. HMAS must be able to **record this request** in text form and laundry services can **view/acknowledge** the request using Google Sheets (I know that this staff side UX is not good, if time persists, I will try to make simple good looking website).
    4. HMAS must **notify/acknowledge** the customer on every updates.
    5. HMAS must be **capable to charge the customer** on basis of the above mentioned meta-information and **transfer the funds to Hotel Bank**. 
3. **Concierge Service**
    1. Customer **can book the car** for travel from one place to other place.
    2. HMAS must be **multi-turn** so that concierge services knows **meta-information about the order**, like **destination** and **time to start the travel**.
    3. HMAS must be **able to record this order** and Concierge staff can **view/acknowledge the order** using Google Sheets.
    4. HMAS must **notify/acknowledge** the customer on every updates.
    5. HMAS must be **capable of charging the customer** on basis of above mentioned meta-information and **transfer the funds to Hotel Bank and Cab services**.
4. **Cleaning Services**
    1. Customer **can schedule cleaning service**, if they are out for some hours.
    2. Customer can also **add note**.
    3. Cleaning staff **can view the request** of the customer.
5. **Smart Home(Room) Services**
    1. Must be able to use smart home skills. Smart home skills are already present on Alexa store. If any new IOT device is added to the room, both manufacturer and developer will need to work on this sub-feature together.

## Top Priority Requirement
Customer should be able to order food using Hotel Management Alexa Skill (HMAS). The order should be received by resturant captain. Customer should also be able to schedule the order.

## Approach
User can behave two ways:
1. User can provide directly the food that they want to eat. This case is trivial. We can directly get the food from the incoming request and will ask if user wants to schedule the order or not and proceed further.
2. User wants the menu first. This part is solved by using disabling the delegate feature. Meaning the backend will direct the flow of the conversation. This case makes the skill multi-turn. Alexa will ask would you like veg food or non veg food and if you select veg then she will procced with the sub types of veg food and so on.

## Use Case Diagram
<img src="resources/image/Use Case Diagram HMAS.jpg">

## High Level Design
<img src="resources/image/High Level Design HMAS-Version 1.jpg">

## Sequence Diagram
<img src="resources/image/Sequence Diagram.jpg">

## Scope for Further Developements
We can also create a fully hosted website for the hotel, which will show the requests from the customers. The webiste can be made interactive to notify the customers that their request is seen by the staff and will give updates at each step.
