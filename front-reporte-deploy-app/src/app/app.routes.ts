import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadChildren: () => import('./report/reporte.routes').then(m => m.routes)
    },
    {
        path: 'not-found',
        loadComponent: () => import('./share/not-found/not-found').then(m => m.NotFound)
    },
    {
        path: '**',
        redirectTo: 'not-found'
    }
];
