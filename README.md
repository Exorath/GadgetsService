# GadgetsService
The Gadgets Service is the service responsible of keeping track of a players gadgets, the database is trading ready.

Copyright 2017 Exorath

## Endpoints

### /players/{uuid}/gadgets?type=hat [GET]:
#### Gets all the gadgets of a player

**Response**:
```json
{
"gadgets": {
  "a5e1b690-9788-4870-a4c1-27e8cfb0c2bc":{
    "type": "HAT",
    "id" : "PUMPKIN_1"
  },"e5ae79bd-3268-4ed5-a1be-17aa8b374cf9":{
    "type": "HAT",
    "id" : "NINJA_1"
  }
}
}
```
### /gadgets/{uuid} [GET]:
#### Gets info about a specific gadget

**Response**:
```json
{
  "type": "HAT",
  "id": "PUMPKIN_1",
  "created": 1494610416364,
  "owner": "f5329035-728e-4c2a-987d-71745551ea5b",
  "meta": {
    "some_key": "some_val"
  }
}
```
### /players/{uuid}/gadgets [POST]:
#### Makes this player purchase a gadget/or give it to him


**Request**:
```json
{
"type": "HAT",
 "id": "PUMPKIN_1",
 "costs": {
   "gold": 10
 },
 "meta": {
   "some_key": "some_val"
 }
}
```

Costs and meta are optional.

**Response**:
```json
{
"success": true,
"uuid" : "a5e1b690-9788-4870-a4c1-27e8cfb0c2bc"}
```

uuid: the gadget uuid

## Environment
| Name | Value |
| --------- | --- |
| MONGO_URI | {mongo_uri} |
| DB_NAME | {db name to store data} |