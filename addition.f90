program addition
implicit none
real :: AFx,AFy,AFz
real :: AMx,AMy,AMz
real :: BFx,BFy,BFz
real :: BMx,BMy,BMz
real :: Fx,Fy,Fz
real :: Mx,My,Mz
open(11,file="A.bin", form="unformatted")
read(11) AFx, AFy, AFz
read(11) AMx, AMy, AMz
close(11)
open(12,file="B.bin", form="unformatted")
read(12) BFx, BFy, BFz
read(12) BMx, BMy, BMz
close(12)

Fx= AFx + BFx
Fy= AFy + BFy
Fz= AFz + BFz
Mx= AMx + BMx
My= AMy + BMy
Mx= AMz + BMz

open(22,form="formatted")
write(22,*) Fx, Fy, Fz
print *,  Fx, Fy, Fz
write(22,*) Mx, My, Mx
print * , Mx, My, Mx
close(22)
end program addition
