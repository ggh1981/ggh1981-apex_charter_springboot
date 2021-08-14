# Setup

## Database

`CREATE SCHEMA charter;`

`CREATE USER 'charteruser'@'localhost' IDENTIFIED BY 'Password01';`

`GRANT ALL PRIVILEGES ON charter.* TO 'charteruser'@'localhost';`
