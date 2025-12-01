import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./reporte-dashboard/feature/dashboard/dashboard').then(m => m.Dashboard)
    },
    {
        path: 'not-found',
        loadComponent: () => import('./share/feature/not-found/not-found').then(m => m.NotFound)
    },
    {
        path: '**',
        redirectTo: 'not-found'
    }
];
