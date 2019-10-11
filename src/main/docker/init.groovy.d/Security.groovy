import hudson.security.HudsonPrivateSecurityRealm
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy
import hudson.security.csrf.DefaultCrumbIssuer

import jenkins.model.Jenkins

def instance = Jenkins.instanceOrNull

// =====================================================================================================================
// Enable CSRF protection (see: https://wiki.jenkins.io/display/JENKINS/CSRF+Protection)
// =====================================================================================================================
instance.setCrumbIssuer(new DefaultCrumbIssuer(true))


// =====================================================================================================================
// Create the admin user
// =====================================================================================================================

def jenkinsRealm = new HudsonPrivateSecurityRealm(false)
jenkinsRealm.createAccount('admin', 'admin')
instance.setSecurityRealm(jenkinsRealm)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(true)
instance.setAuthorizationStrategy(strategy)


// =====================================================================================================================
// Save everything
// =====================================================================================================================
instance.save()
