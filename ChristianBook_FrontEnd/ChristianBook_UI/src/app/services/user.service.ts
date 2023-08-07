import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url =environment.apiUrl +"/api/v1/user";
  
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) {}

  public login(loginData: any) {
    return this.httpclient.post(this.url + '/login', loginData,
     {
     headers: this.requestHeader,
    }
    );
  }
  public register(registerData:any){
    return this.httpclient.post(this.url + '/api/v1/user/sigup', registerData );
  }
 
  public roleMatch(allowedRoles:any):any {
    let isMatch = true;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      
          if (userRoles.role === allowedRoles) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
  
    }
  }
}
