SELECT *
FROM tblOrders
WHERE CustomerID = 'MAGAA';

SELECT 
    CustomerID,
    CompanyName, ContactName, ContactTitle
FROM tblCustomers
WHERE ContactTitle <> 'Sales Associate';

SELECT DISTINCT c.CustomerID, c.CompanyName, p.ProductID, p.ProductName, p.EnglishName
FROM tblCustomers c
    JOIN tblOrders o ON c.CustomerID = o.CustomerID
    JOIN tblOrderDetails od ON o.OrderID = od.OrderID
    JOIN tblProducts p ON od.ProductID = p.ProductID
WHERE p.EnglishName LIKE '%chocolate%';

SELECT DISTINCT c.CustomerID, c.CompanyName, o.ShipCountry, p.ProductID, p.ProductName, p.EnglishName
FROM tblCustomers c
    JOIN tblOrders o ON c.CustomerID = o.CustomerID
    JOIN tblOrderDetails od ON o.OrderID = od.OrderID
    JOIN tblProducts p ON od.ProductID = p.ProductID
WHERE o.ShipCountry IN ('Italy', 'USA');

SELECT od.OrderID, od.ProductID, p.ProductName, od.UnitPrice, od.Quantity, od.Discount,
    (od.UnitPrice * od.Quantity * (1 - od.Discount)) AS TotalPrice
FROM tblOrderDetails od
    JOIN tblProducts p ON od.ProductID = p.ProductID;

SELECT CategoryID, COUNT(p.ProductID) AS TotalProducts
FROM tblProducts p
GROUP BY CategoryID
ORDER BY TotalProducts ASC;

SELECT Country, City, COUNT(CustomerID) AS TotalCustomers
FROM tblCustomers
GROUP BY Country, City;

SELECT OrderID, OrderDate, RequiredDate, ShippedDate
FROM tblOrders
WHERE ShippedDate > RequiredDate;
