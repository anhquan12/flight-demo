import {RouterModule, Routes} from '@angular/router';
import {ListAirportComponent} from './component/list-airport/list-airport.component';

const routes: Routes = [
  { path: 'list-airport', component: ListAirportComponent },

];

export const routing = RouterModule.forRoot(routes);
