def prime_factors(n):
    result = []

    if n % 2 == 0:
        result.append(2)
        while n % 2 == 0:
            n = n / 2

    i = 3
    while i * i  <= n:
        if n % i == 0:
            result.append(i)
            while n % i == 0:
                n = n / i
        i += 2

    if n > 2:
        result.append(n)
    return result

if __name__ == "__main__":
    print(prime_factors(32))
    print(prime_factors(6))
    print(prime_factors(100))
    print(prime_factors(35))
    print(prime_factors(99))
    print(prime_factors(97))

