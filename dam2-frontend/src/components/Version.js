import React from 'react';
import packageJson from '../../package.json';

function Version() {
    return <div>UI Version <a href={"#git"}>{packageJson.version}</a></div>;
}

export default Version;
