program formatage
implicit none
real :: Fx,Fy,Fz
real :: Mx,My,Mz
open(11,form="formatted")
read(11,*) Fx, Fy, Fz, Mx, My, Mz
close(11)
open(12,form="unformatted")
write(12) Fx, Fy, Fz
print *,  Fx, Fy, Fz
write(12) Mx, My, Mx
print * , Mx, My, Mx
close(12)
end program formatage
