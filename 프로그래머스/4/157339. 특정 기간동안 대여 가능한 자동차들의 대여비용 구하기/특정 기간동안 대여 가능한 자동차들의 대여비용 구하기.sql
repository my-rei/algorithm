-- 자동차 종류가 '세단' 또는 'SUV'
-- 대여 가능 2022-11-01 2022-11-30 
-- 총 대여 금액 50만원 이상 200만원 미만 



SELECT c.CAR_ID, c.CAR_TYPE, FLOOR(c.DAILY_FEE * 30 * (100-CONVERT(REPLACE(cd.DISCOUNT_RATE, '%', ''), SIGNED))/100) AS FEE 
FROM CAR_RENTAL_COMPANY_CAR c
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN cd
ON c.CAR_TYPE = cd.CAR_TYPE 
    AND 
    cd.DURATION_TYPE = '30일 이상'
WHERE 
    c.CAR_ID NOT IN (
        SELECT ic.CAR_ID
        FROM CAR_RENTAL_COMPANY_CAR ic
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY ich
        ON ic.CAR_ID = ich.CAR_ID
            AND (
                (ich.START_DATE <= CONVERT('2022-11-30', DATE) AND ich.END_DATE > CONVERT('2022-11-01', DATE))
            )
    )
AND
    c.CAR_TYPE IN ('세단', 'SUV')
AND
    FLOOR(c.DAILY_FEE * 30 * (100-CONVERT(REPLACE(cd.DISCOUNT_RATE, '%', ''), SIGNED))/100) >= 500000 AND FLOOR(c.DAILY_FEE * 30 * (100-CONVERT(REPLACE(cd.DISCOUNT_RATE, '%', ''), SIGNED))/100) < 2000000 
ORDER BY
    FEE DESC,
    CAR_TYPE ASC,
    CAR_ID DESC



-- sd가 1~30 사이거나, ed가 1~30 사이인 열의 아이디만 추출 

-- sd 11/30 이전 ed 11/1 이후 -> 불가
-- sd 11/30 이전 ed 11/1 이전 -> 가능
-- sd 11/30 이후 ed 11/1 이후 -> 가능
-- sd 11/30 이후 ed 11/1 이전 -> XXX 

