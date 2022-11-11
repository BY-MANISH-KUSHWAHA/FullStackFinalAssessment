# SQL

## => (PK )Primary Key: Unique Key for identifying a row in a table

## => (FK) Foreign Key: Whenever we have your primary key placed in another table => reference to the actual that table has your primary key => Link the records

# Relationships

## One-One
![http://http://localhost:8080/h2-console](assets/0.PNG)
![http://http://localhost:8080/h2-console](assets/3.PNG)
![http://http://localhost:8080/h2-console](assets/4.PNG)
![http://http://localhost:8080/h2-console](assets/5.PNG)

### GetALLPlayers
![http://http://localhost:8080/h2-console](assets/6.PNG)

### AddPlayerWithProfileObject
![http://http://localhost:8080/h2-console](assets/7.PNG)
```
Pre-Request:
 var name = pm.request.body;
 const obj = JSON.parse(name.raw);
 pm.environment.set("instaPlayer_ProfileRandom",`${obj.name}-Profile_${Date.now().toString().substring(1,5)}@myDomain.co.uk`);
```

### GetPlayerById
![http://http://localhost:8080/h2-console](assets/8.PNG)

### DeletePlayerById
![http://http://localhost:8080/h2-console](assets/9.PNG)

### ----------------------------------------------------

### GetALLPlayerProfiles
![http://http://localhost:8080/h2-console](assets/10.PNG)

### AddPlayerProfile
![http://http://localhost:8080/h2-console](assets/11.PNG)
```
Pre-Request:
 pm.environment.set("instaProfileRandom", `OnlyProfileWithoutPlayer_${Date.now()}@myDomain.co.uk`)
```

### GetPlayerProfileById
![http://http://localhost:8080/h2-console](assets/12.PNG)

### DeletePlayerProfileById
![http://http://localhost:8080/h2-console](assets/13.PNG)
```
If Profile is assign to any player then we can't delete it.
but If profile is not assign then we can.
```


### ----------------------------------------------------

### Add Player Without Player
![http://http://localhost:8080/h2-console](assets/14.PNG)
```
Pre-Request:
 var name = pm.request.body;
 const obj = JSON.parse(name.raw);
 pm.environment.set("instaPlayer_ProfileRandom",`${obj.name}-Profile_${Date.now().toString().substring(1,5)}@myDomain.co.uk`);

Test:
 var id = pm.response.json();
 pm.environment.set("generatedId-Player",id.id);
```
### Add Profile
![http://http://localhost:8080/h2-console](assets/15.PNG)
```
Pre-Request:
 pm.environment.set("instaProfileRandom", `OnlyProfileWithoutPlayer_${Date.now()}@myDomain.co.uk`)

Test:
 var id = pm.response.json();
 pm.environment.set("generatedId-Profile",id.id);
```
## Assign Profile to a Player
![http://http://localhost:8080/h2-console](assets/16.PNG)



## One-Many
![http://http://localhost:8080/h2-console](assets/1.PNG)

## Many-Many
![http://http://localhost:8080/h2-console](assets/2.PNG)

