package test

email isEmail ["Invalid email"]

age toPositiveInt ["Invalid age"] >> {it > 18} ["You must be adult"]
