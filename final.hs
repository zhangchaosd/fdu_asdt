import qualified  Data.List as List

main = do
    putStrLn "Please input your position like this:"
    let exampleStr = ["o..", "x.o", ".xo"]
    mapM_ putStrLn exampleStr
    putStrLn "Please input yours:"
    -- to opt
    l1 <- getLine
    l2 <- getLine
    l3 <- getLine
    let inputposition = [l1,l2,l3]
    putStrLn "Now please tell me you are 'x' or 'o':"
    qizi <- getLine
    -- 检查合法性todo 两层all 相差不超过1，已经胜利或者输了
    putStrLn "All done!"
    
    --mapM_ putStrLn inputposition
    --putStrLn qizi
    -- if qizi == 'o' exchange
    let curposition = if qizi == "x" then inputposition
                  else exc inputposition
    --mapM_ putStrLn curposition
    showresult $ static curposition 0--0:o turn   1:x turn
    return ()




    --win 1   ping 0   lost -1
    -- x 先

static curposition t = static_xturn curposition



static_xturn [] = 0
static_xturn curposition
                    | (- 1) `elem` results = 1
                    | 0 `elem` results = 0
                    | otherwise  = -1
                    where results = map static_oturn $ getnexts curposition 'x'


static_oturn [] = 0
static_oturn curposition 
                    | (- 1) `elem` results = 1
                    | 0 `elem` results = 0
                    | otherwise  = -1
                    where results = map static_xturn $ getnexts curposition 'o'



getnexts :: [String] -> Char -> [[String]]
getnexts curposition c = let pss = getpss curposition c
                         in [ps | ps<-pss,ps/=curposition]


getpss :: [String] -> Char -> [[String]]
getpss curposition c = let hs = [0, 1, 2]
                           ret = [changev curposition 0 0 c, changev curposition 0 1 c,changev curposition 0 2 c,
                                 changev curposition 1 0 c, changev curposition 1 1 c,changev curposition 1 2 c,
                                 changev curposition 2 0 c, changev curposition 2 1 c,changev curposition 2 2 c]
                        in ret

--done
showresult sta = case sta of 1 -> putStrLn "You will win!!!!!!!!!"
                             0 -> putStrLn "ping"
                             -1 -> putStrLn "you are lost"
                             _ -> putStrLn "We have a big big problem"

--done
iswin curposition xsoros = let ls = getls curposition
                    in elem xsoros ls

--done to opt
getls curposition = let ct = List.transpose curposition
                    in [curposition !! 0, curposition !! 1, curposition !! 2,
                        ct !! 0, ct !! 1, ct !! 2,
                        ct !! 0 !! 0 : ct !! 1 !! 1 : [ct !! 2 !! 2], ct !! 2 !! 0 : ct !! 1 !! 1 : [ct !! 0 !! 2]]

--done exchange o x
exc = map (\str -> [if c=='x' then 'o' else if c=='o' then 'x' else c | c <- str])

--done to opt
changev (l1:l2:l3:_) h v c
                | h == 0 = [cg2 l1 v, l2, l3]
                | h == 1 = [l1, cg2 l2 v, l3]
                | h == 2 = [l1, l2, cg2 l3 v]
                where cg2 (e1:e2:e3:_) v
                        |v == 0 = [if e1 == '.' then c else e1, e2, e3]
                        |v == 1 = [e1, if e2 == '.' then c else e2, e3]
                        |v == 2 = [e1, e2, if e3 == '.' then c else e3]