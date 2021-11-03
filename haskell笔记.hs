head [5,4,3,2,1] 取首元素
tail 除首元素之外其余元素
last 最后一个元素
init 除last之外其余元素
length [1,2,3] 返回长度
null [1,2,2] 检查空
reverse [5,4,3,2,1] 反转
take 3 [5,4,3,2,1] 取前三个元素
drop 3 [8,4,2,1,5,6] 丢弃前三个
minimum [8,4,2,1,5,6] 
maximum [1,9,2,3,4]
sum [5,2,1,6,3,2,5,7] 
product [6,2,1,2]
4 `elem` [3,4,5,6]  4是否存在于list，常用中缀
[1..20] 一到20
['a'..'z'] 得到 "abcdefghijklmnopqrstuvwxyz"
['K'..'Z'] 得到 "KLMNOPQRSTUVWXYZ"
[2,4..20] 指定间隔 [2,4,6,8,10,12,14,16,18,20]
[3,6..20] 指定间隔 [3,6,9,12,15,18]
得到20到1 [20,19..1]
[0.1, 0.3 .. 1] 使用浮点数小心 [0.1,0.3,0.5,0.7,0.8999999999999999,1.0999999999999999]
取前 24 個 13 的倍數 可以 [13,26..24*13]，但有更好的方法： take 24 [13,26..]
take 10 (cycle [1,2,3]) 得到 [1,2,3,1,2,3,1,2,3,1]
take 12 (cycle "LOL ") 得到 "LOL LOL LOL "
take 10 (repeat 5) 得到 [5,5,5,5,5,5,5,5,5,5]，用 replicate 3 10 更简单得到 [10,10,10]
[x*2 | x <- [1..10]] 得到 [2,4,6,8,10,12,14,16,18,20]
[x*2 | x <- [1..10], x*2 >= 12] 得到 [12,14,16,18,20]  逗号分隔限制条件
[ x | x <- [50..100], x `mod` 7 == 3] 得到 [52,59,66,73,80,87,94]
boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x] 使 List 中所有大於 10 的奇數變為 "BANG"，小於 10 的奇數變為 "BOOM"，其他則統統扔掉
boomBangs [7..13]  得到 ["BOOM!","BOOM!","BANG!","BANG!"]
[ x | x <- [10..20], x /= 13, x /= 15, x /= 19] 得到 [10,11,12,14,16,17,18,20]
[ x*y | x <- [2,5,10], y <- [8,10,11]] 得到 [16,20,22,40,50,55,80,100,110]
[ x*y | x <-[2,5,10], y <- [8,10,11], x*y > 50] 加个筛选 [55,80,100,110]
length' xs = sum [1 | _ <- xs]  自己实现length
removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']]  取大写字母
fst ("Wow", False) 返回首项 "Wow"
snd ("Wow", False) 返回尾项 False  注意这两种只能用于大小为2的tuple
zip [1 .. 5] ["one", "two", "three", "four", "five"] 得到 交叉组装 [(1,"one"),(2,"two"),(3,"three"),(4,"four"),(5,"five")]


ch03 Types and Typeclasses

:t "HELLO!"  显示类型  "HELLO!" :: [Char]
Int 32位  Integer 无界 Double
factorial 50 阶乘
circumference 4.0 得到 圆周长 25.132742
Typeclass:
Eq 包含可判斷相等性的型別。提供實現的函數是 == 和 /=。
Ord 包含可比較大小的型別
型別若要成為Ord的成員，必先加入Eq家族。
"Abrakadabra" `compare` "Zebra" 得到 LT   ，compare函数返回LT或GT或EQ
show 5.334 转换为字符串 "5.334"
read "[1,2,3,4]" ++ [3] 与show相反，++好像是连接？ [1,2,3,4,3]。用后面的东西来判断转成什么类型
read "[1,2,3,4]" :: [Int] 显式说明类型得到 [1,2,3,4] 
=> 符號。它左邊的部分叫做型別約束。
succ 'B' 得到 'C'
Enum 的成員都是連續的型別 -- 也就是可枚舉。Enum 類存在的主要好處就在於我們可以在 Range 中用到它的成員型別：每個值都有後繼子 (successer) 和前置子 (predecesor)，分別可以通過 succ 函數和 pred 函數得到
Bounded 的成員都有一個上限和下限。minBound :: Int 得到 -2147483648
如果其中的項都屬於 Bounded Typeclass，那麼該 Tuple 也屬於 Bounded
:t 20 得到 20 :: (Num t) => t
:t (*) 得到 (*) :: (Num a) => a -> a -> a
Num 包含所有的數字：實數和整數
Integral 僅包含整數，其中的成員型別有 Int 和 Integer
Floating 僅包含浮點型別：Float 和 Double
fromIntegral 函数其型別聲明為： fromIntegral :: (Num b, Integral a) => a -> b，用来把Integral转换为更通用的形式


模式匹配，保留整体引用
capital :: String -> String  
capital "" = "Empty string, whoops!"  
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

let 定义局部函数
[let square x = x * x in (square 5, square 3, square 2)]  
[(25,9,4)]

(let a = 100; b = 200; c = 300 in a*b*c, let foo="Hey "; bar = "there!" in foo ++ bar)  
(6000000,"Hey there!")

calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2]

foldl foldr foldl1
scanl scanr scanl1
scanl (+) 0 [3,5,2,1] 得到 [0,3,8,10,11] 
scanr (+) 0 [3,5,2,1] 得到 [11,8,3,1,0]

$ 降低优先级

. 函数结合
map (negate . abs) [5,-3,-6,7,-3,2,-19,24]  
[-5,-3,-6,-7,-3,-2,-19,-24]


ghci 中装载模组
:m Data.List Data.Map Data.Set

import Data.List (nub，sort)
import Data.List hiding (nub)
import qualified Data.Map as M
import qualified Data.Set as Set