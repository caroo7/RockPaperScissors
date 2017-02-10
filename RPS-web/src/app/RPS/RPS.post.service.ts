import {Http, Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import { RPSResult } from './RPSresult'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'
import {Injectable} from '@angular/core'

@Injectable()
export class PostService {

    private url = "http://localhost:8080/game"
    headers = new Headers({ 'Content-Type': 'application/json' });
    options = new RequestOptions({ headers: this.headers });

    constructor(private http: Http) {
    }

    createPost(post) : Observable<RPSResult> {
        return this.http.post(this.url, JSON.stringify(post), this.options)
            .map((response : Response) => response.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

}