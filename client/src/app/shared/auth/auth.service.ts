import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';

import { API_OAUTH_TOKEN } from '../api-util';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {

    private tokenExpirationDate: Date = null;
    private userData: any = null;
    private tokenData: OAuth2Token;

    constructor(public http: Http) {

    }

    public isAuthenticated(): boolean {
        return !(localStorage.getItem('token') === null);
    }

    public authenticate(username: string, password: string): Observable<any> {

        let headers = new Headers();
        headers.append('Authorization', 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0');
        headers.append('Accept', `application/json`);
        headers.append('Content-Type', `application/x-www-form-urlencoded`);

        return this.http
            .post(API_OAUTH_TOKEN + '?grant_type=password&username=' + username + '&password=' + password, {}, headers)
            .map(this.handleData)
            .catch(this.handleError);
    }

    public getToken(): string {
        return localStorage.getItem('token');
    }

    public logout() {
        localStorage.removeItem('token');
    }

    private handleData(res: Response) {
        let body = res.json();
        localStorage.setItem('token', body.access_token);
        return body;
    }

    private handleError(error: any) {

        let errMsg = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : 'Server error';

        return Observable.throw(errMsg);
    }
}
