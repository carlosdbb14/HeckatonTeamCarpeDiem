set
i productos /1 aceites cocina, 2 olivas, 3 margarina,4 aceite balsamico /
j plantas /1 buga , 2 barranquilla , 3 bucaramanga /
k centros de distribucion /1 funza , 2 cali , 3 pereira, 4 medellin, 5 bucaramanga , 6 ibague /
c clientes /1*20/

free variable z;
positive variables
x(i,j,k) cantidad de producto i a enviar desde la planta j hasta el centro de distrib k
y(i,k,c) cantidad cantidad de producto i a enviar desde el centro de distrib k hasta el cliente c
;
binary variables
bx(i,j,k) posibilidad de que el producto i se envie desde la planta de produccion j hasta el centro de distrib j
by(i,k,c) posibilidad de que el producto i se envie desde el centro de distrib j hasta el cliente c
;

scalar
ca min envio de productos
/
2
/
;

table
d(c,i) demanda del producto i segun el cliente c
         1       2       3       4
1        1       0       4       0
2        2       1       0       0
3        0       3       7       0
4        0       1       4       0
5        0       3       2       0
6        1       0       2       0
7        1       0       3       0
8        0       0       7       0
9        0       3       0       0
10       0       3       0       0
11       2       0       5       0
12       2       2       2       0
13       1       0       3       4
14       3       0       2       0
15       0       0       2       2
16       4       3       2       1
17       5       2       0       0
18       2       3       1       0
19       0       1       0       2
20       1       2       3       0
;
table
di(j,k) distancia en kilometros desde la planta j hasta el centro de distribucion k
          1      2       3       4       5      6
1         13     11      25.5    9       7      10
2         9      4       5       23      28     30
3         40     50      30      3       12      8
;
table
dt(k,c) distancia en kilometros desde el centro de distribucion k hasta el cliente c
          1      2       3
1         25.1   31      8.3
2         13     12      9
3         10     11      12
4         15     20      41
5         31     28      20
6         21     13      3.8
;
equations
fo funcion objetivo
r1(j,i) min de envio desde las plantas j por producto i
r2(k,i) min de envio desde los centros de distr k por cada producto i
r3(i,k) balance
r4(k,i,c) demanda del producto n del cliente l
r5(c) demanda indivisible
r6 productos de margarina no salen desde plantas buga
r7 productos de margarina no salen desde planta barranquilla
r8 productos de margarina salen de bogota
r9
r10
r11(i,j,k) empalme de x(ijk) con bx(ijk)
r12(i,k,c) empalme de y(ikc) con by(ikc)
;

fo..z=e=sum((i,j,k),x(i,j,k)*di(j,k))+sum((i,k,c),y(i,k,c)*dt(k,c));
r1(j,i)..sum(k,x(i,j,k))=g=sum(k,ca*bx(i,j,k));
r2(k,i)..sum(c,y(i,k,c))=g=sum(c,ca*by(i,k,c));
r3(i,k)..sum(j,x(i,j,k))=e=sum(c,y(i,k,c));
r4(k,i,c)..y(i,k,c)=e=d(c,i)*by(i,k,c);
r5(c)..sum((k,i),by(i,k,c))=e=1;
r6..sum(k,x("3","1",k))=e=0;
r7..sum(k,x("3","2",k))=e=0;
r8..sum(k,x("1","3",k))=e=0;
r9..sum(k,x("2","3",k))=e=0;
r10..sum(k,x("4","3",k))=e=0;
r11(i,j,k)..x(i,j,k)=l=bx(i,j,k)*1000000;
r12(i,k,c)..y(i,k,c)=l=by(i,k,c)*1000000;

model Teamfoods/all/
solve Teamfoods using MIP minimizing z;
display x.l,y.l,z.l,bx.l,by.l;
