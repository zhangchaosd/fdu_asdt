import qualified  Data.List as List
import qualified Control.Monad as Monad

main = do 
  str <- getLine
  let ret = sum [1|x<-str,x=='x']
  let str2 = ["xo.","xo."]
  let ret2 = all (all (\c->c=='x'||c=='o'||c=='.')) str2
  print ret
  return ()











changeElem :: [String] -> Int -> Int -> Char -> [String]
changeElem xs row col x =
    let row_to_replace_in = xs !! row
        modified_row = replace col x row_to_replace_in
    in replace row modified_row xs

replace :: Int -> a -> [a] -> [a]
replace 0 x (_:xs) = x:xs
replace i x (h:xs) = h : replace (i-1) x xs



--mapM_ putStrLn curposition
  --done to opt 修改二维列表中的值，仅限 3 x 3
changev (l1:l2:l3:_) h v c
                | h == 0 = [cg2 l1 v, l2, l3]
                | h == 1 = [l1, cg2 l2 v, l3]
                | h == 2 = [l1, l2, cg2 l3 v]
                where cg2 (e1:e2:e3:_) v
                        |v == 0 = [if e1 == '.' then c else e1, e2, e3]
                        |v == 1 = [e1, if e2 == '.' then c else e2, e3]
                        |v == 2 = [e1, e2, if e3 == '.' then c else e3]