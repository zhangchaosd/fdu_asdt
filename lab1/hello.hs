import Data.List


doubleMe x = x + x
doubleUs x y = x + x + y + y

bmiTell weight height  
    | weight / height ^ 2 <= 18.5 = "You're underweight, you emo, you!"  
    | weight / height ^ 2 <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | weight / height ^ 2 <= 30.0 = "You're fat! Lose some weight, fatty!"  
    | otherwise                 = "You're a whale, congratulations!"

-- 关键字 where
bmiTell' weight height  
    | bmi <= skinny = "You're underweight, you emo, you!"  
    | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= fat    = "You're fat! Lose some weight, fatty!"  
    | otherwise     = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2  
          (skinny, normal, fat) = (18.5, 25.0, 30.0)

a `myCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT


initials' firstname lastname = [f] ++ ". " ++ [l] ++ "."
    where (f:_) = firstname
          (l:_) = lastname

calcBmis xs = [bmi w h | (w, h) <- xs] 
    where bmi weight height = weight / height ^ 2

-- :l hello.hs


-- 关键字 let
-- 在 let 中綁定的名字僅對 in 部分可見。
-- let 綁定本身是個表達式，可以随处安放，而 where 綁定則是個語法結構。if 也是个表达式
cylinder r h = 
    let sideArea = 2 * pi * r * h  
        topArea = pi * r ^2  
    in  sideArea + 2 * topArea

calcBmis2 xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi >= 25.0]

-- case
head' xs = case xs of [] -> error "No head for empty lists!"  
                      (x:_) -> x

describeList xs = "The list is " ++ case xs of [] -> "empty."  
                                               [x] -> "a singleton list."   
                                               xs -> "a longer list."

describeList2 xs = "The list is " ++ what xs  
    where what [] = "empty."  
          what [x] = "a singleton list."  
          what xs = "a longer list."


testdeep [] = error "er"
testdeep [x] = x
testdeep (x:xs)
    | x > tmax = x
    | otherwise = tmax
    where tmax = testdeep xs

replicate' n x  
    | n <= 0    = []  
    | otherwise = x:replicate' (n-1) x

take' n _  
    | n <= 0   = []  
take' _ []     = []  
take' n (x:xs) = x : take' (n-1) xs


reverse' [] = []  
reverse' (x:xs) = reverse' xs ++ [x]



repeat' x = x:repeat' x


zip' _ [] = []  
zip' [] _ = []  
zip' (x:xs) (y:ys) = (x,y):zip' xs ys


elem' a [] = False  
elem' a (x:xs)  
    | a == x    = True  
    | otherwise = a `elem'` xs


quicksort' [] = []
quicksort' (x:xs) = 
    let smalls = quicksort' [a | a <- xs, a <= x]
        bigs = quicksort' [a | a <- xs, a > x]
    in smalls ++ [x] ++ bigs


-- 高阶函数
zipWith' _ [] _ = []  
zipWith' _ _ [] = []  
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys