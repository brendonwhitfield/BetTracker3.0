INSERT INTO BET_TYPE (Id, Sport) VALUES (1, 'Football');
INSERT INTO BET_TYPE (Id, Sport) VALUES (2, 'Horse Racing');
INSERT INTO BET_TYPE (Id, Sport) VALUES (3, 'Football');

INSERT INTO Users (Id, First_Name, Last_Name, Email, Address, Date_Of_Birth) VALUES (1, 'Brendon', 'Whitfield', 'brendonwhitfield@email.com', 'brendons house', '1999-09-22');
INSERT INTO Users (Id, First_Name, Last_Name, Email, Address, Date_Of_Birth) VALUES (2, 'Ben', 'Whitefield', 'benwhitefield@email.com', 'bens house', '1989-05-12');
INSERT INTO Users (Id, First_Name, Last_Name, Email, Address, Date_Of_Birth) VALUES (3, 'Ken', 'Doll', 'Kendoll@email.com', 'barbies house', '1959-07-22');

INSERT INTO Bets (Id, Description, Outcome, Stake, Odds, Profit_Loss, Bet_Date, Bet_Type_Id, Users_Id) VALUES (1, 'Single', 'Win', 3.50, 5.0, 17.50, '2007-12-03T10:15:30.00Z', 1, 3);
INSERT INTO Bets (Id, Description, Outcome, Stake, Odds, Profit_Loss, Bet_Date, Bet_Type_Id, Users_Id) VALUES (2, 'Double', 'Loss', 1.0, 2.0, 1.0, '2007-12-03T10:15:30.00Z', 1, 2);
INSERT INTO Bets (Id, Description, Outcome, Stake, Odds, Profit_Loss, Bet_Date, Bet_Type_Id, Users_Id) VALUES (3, 'Double', 'win', 1.0, 3.0, 3.0, '2007-12-03T10:15:30.00Z', 3, 1);

