--reset id 
-- DBCC CHECKIDENT ('dbo.Account', RESEED, 1)

create proc getDataAccount
AS
BEGIN
SELECT * FROM Account;
END
GO

CREATE PROC insertDataAcc
@NAME nvarchar(50),
@AGE date,
@GENDER bit
AS
BEGIN

INSERT INTO Account(AccFullName,AccBirthDay,AccGender)
VALUES(@NAME,@AGE,@GENDER)
END
GO

CREATE PROC updateDataAcc
@NAME nvarchar(50),
@DOB date,
@GENDER bit,
@ID int
AS BEGIN
UPDATE Account
SET AccFullName = @NAME, AccBirthDay = @DOB, AccGender = @GENDER WHERE AccId = @ID
END
GO

CREATE PROC deleteDataAcc
@ID int
AS
BEGIN

DELETE FROM Account
WHERE AccId = @ID

END
GO

ALTER PROC searchDataAcc
@NAME nvarchar(50)
AS 
BEGIN
SELECT * FROM Account WHERE AccFullName Like N'%@NAME%';
END
GO

CREATE PROC TimKiem
@ID int
AS 
BEGIN
SELECT * FROM Account WHERE AccId = @ID;
END
GO