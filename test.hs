main = do
        let vs = ["ooo","ooo","ooo"]
        let sz = [1,2,3,4,5]
        let sz2 = [x|x<-sz,x/=2]
        print sz2

cg (l1:l2:l3:_) h v 
                | h == 0 = [cg2 l1 v,l2,l3]
                | h == 1 = [l1,cg2 l2 v,l3]
                | h == 2 = [l1,l2,cg2 l3 v]
                where cg2 (e1:e2:e3:_) v
                                        |v==0 = ['x',e2,e3]
                                        |v==1 = [e1,'x',e3]
                                        |v==2 = [e1,e2,'x']
