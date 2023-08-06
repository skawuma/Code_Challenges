import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(role:[]) {
    localStorage.setItem('role', JSON.stringify(role));
  }
  public setRoles1(role:any) {
    localStorage.setItem('role', role);
  }

  // public getRoles1():[] {
  //   return JSON.parse(localStorage.getItem('role')??'null'); 
  // }
  public getRoles(): any {
    return (localStorage.getItem('role'));
  }

  public setToken(jwtToken: any) {
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken():any{
    return localStorage.getItem('jwtToken') ;
  }

  public clear() {
    localStorage.clear();
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();

  }

public isAdmin(){

const role= this.getRoles();
//console.log(roles);
return  role==='Admin';

}


public isUser(){

  const role = this.getRoles();
 // console.log(roles);
  return  role ==='User';
  
  }
}
