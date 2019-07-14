package com.example.jvm.concurrent;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CacheService {

    private AtomicReference<BigInteger> lastNumber = new AtomicReference<>();

    private AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();


    /**
     * 要保持状态的一致性，就需要在单个原子操作中更新所以相关的状态变量
     *
     * @param bigInteger
     * @return
     */
    public BigInteger[] service(BigInteger bigInteger) {
        BigInteger[] factors = null;
        if (bigInteger.equals(lastNumber.get())) {
            factors = lastFactors.get();
        } else {
            factors = new BigInteger[]{bigInteger, bigInteger, bigInteger};
            synchronized (CacheService.class) {
                lastNumber.set(bigInteger);
                lastFactors.set(factors);
            }
        }

        return factors;
    }

}
