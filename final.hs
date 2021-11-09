import qualified  Data.List as List
import qualified Control.Monad as Monad

main :: IO ()
main = do
    putStrLn "Please input your position like this:"
    let examplePosition = ["o..", "x.o", ".xo"]
    mapM_ putStrLn examplePosition
    putStrLn "Now please input yours:"
    --inputposition <- Monad.replicateM 3 getLine
    let inputposition = ["...","...","..."]-- todelete
    -- TODO 检查 inputposition 合法性，两层all 相差不超过1，已经胜利或者输了，是否下满

    -- assert len == 3
    let len = length inputposition
    -- assert len2 == True
    let len2 = all ((==3) . length) inputposition
    -- asser ele == True  检查元素是否是 'x'，'o'，'.'
    let ele = all (all (\c->c=='x'||c=='o'||c=='.')) inputposition
    
    putStrLn "Now please tell me you are 'x' or 'o':"
    --piece <- getLine
    let piece = "x" -- todelete
    putStrLn $ if piece /="o" && piece /= "x" then "What?" else "ok"

    -- 始终站在 x 的角度
    let curposition = if piece == "o" then excxo inputposition else inputposition
    mapM_ putStrLn curposition
    showresult $ static 'x' curposition
    return ()

-- 核心逻辑
static :: (Eq p, Num p) => Char -> [[Char]] -> p
static c [] = 0
static c curposition 
    | iswin curposition $ if c=='x' then "ooo" else "xxx" = - 1
    | (- 1) `elem` results = 1
    | 0 `elem` results || null results = 0
    | otherwise  = - 1
    where results = map (static $ if c == 'x' then 'o' else 'x') $ getnexts curposition c

countLetters str c = sum [1 | x <- str, x == c]
countLetters2 str c = length $ filter (== c) str

-- 筛选掉无意义的走法
getnexts :: [String] -> Char -> [[String]]
getnexts curposition c = let pss = getpss curposition c 2 2
                         in [ps | ps <- pss, ps /= curposition]

-- 尝试在每个位置走一步
getpss curposition c row col
    | row == -1 = []
    | otherwise  = changev curposition row col c :getpss curposition c (if col-1<0 then row-1 else row) (if col-1<0 then 2 else col-1)

--done
showresult :: (Eq a, Num a) => a -> IO ()
showresult score = case score of 1 -> putStrLn "You will win!!!!!!!!!"
                                 0 -> putStrLn "No one can win"
                                 - 1 -> putStrLn "You are lost"
                                 _ -> putStrLn "We have a big big problem"

-- 检查是否有人获胜
iswin :: Eq a => [[a]] -> [a] -> Bool
iswin curposition xxx_Or_ooo = let ls = getRowsAndCols curposition
                    in elem xxx_Or_ooo ls

-- to opt 取出每一行每一列和两条对角线，用于检查是否有人获胜
getRowsAndCols :: [[a]] -> [[a]]
getRowsAndCols curposition = let ct = List.transpose curposition
                    in [curposition !! 0, curposition !! 1, curposition !! 2,
                        ct !! 0, ct !! 1, ct !! 2,
                        ct !! 0 !! 0 : ct !! 1 !! 1 : [ct !! 2 !! 2], ct !! 2 !! 0 : ct !! 1 !! 1 : [ct !! 0 !! 2]]

-- 交换 x 和 o
excxo :: [String] -> [String]
excxo = map (\str -> [if c=='x' then 'o' else if c=='o' then 'x' else c | c <- str])

-- 修改二维列表中的值，仅限 3 x 3
changev (l1:l2:l3:_) h v c
                | h == 0 = [cg2 l1 v, l2, l3]
                | h == 1 = [l1, cg2 l2 v, l3]
                | h == 2 = [l1, l2, cg2 l3 v]
                where cg2 (e1:e2:e3:_) v
                        |v == 0 = [if e1 == '.' then c else e1, e2, e3]
                        |v == 1 = [e1, if e2 == '.' then c else e2, e3]
                        |v == 2 = [e1, e2, if e3 == '.' then c else e3]


-- 修改二维列表里的值，比 上面的方法少了对 '.' 的判断，不能用
changeElem :: [String] -> Int -> Int -> Char -> [String]
changeElem xs row col x = 
    let row_to_replace_in = xs !! row
        modified_row = replace col x row_to_replace_in
    in replace row modified_row xs

replace :: Int -> a -> [a] -> [a]
replace 0 x (_:xs) = x:xs
replace i x (h:xs) = h : replace (i-1) x xs